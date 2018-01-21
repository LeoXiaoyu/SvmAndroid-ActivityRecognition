package smv.lovearthstudio.com.svmproj.svm;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import libsvm.svm;
import libsvm.svm_model;
import libsvm.svm_node;
import smv.lovearthstudio.com.svmproj.util.Features;

import static java.lang.Double.parseDouble;
import static smv.lovearthstudio.com.svmproj.util.Constant.FUN_101_MINIMUM_CODE;
import static smv.lovearthstudio.com.svmproj.util.Constant.FUN_102_MAXIMUM_CODE;
import static smv.lovearthstudio.com.svmproj.util.Constant.FUN_103_VARIANCE_CODE;
import static smv.lovearthstudio.com.svmproj.util.Constant.FUN_104_MEANCROSSINGSRATE_CODE;
import static smv.lovearthstudio.com.svmproj.util.Constant.FUN_105_STANDARDDEVIATION_CODE;
import static smv.lovearthstudio.com.svmproj.util.Constant.FUN_106_MEAN_CODE;
import static smv.lovearthstudio.com.svmproj.util.Constant.FUN_112_RMS_CODE;
import static smv.lovearthstudio.com.svmproj.util.Constant.FUN_114_IQR_CODE;
import static smv.lovearthstudio.com.svmproj.util.Constant.FUN_115_MAD_CODE;
import static smv.lovearthstudio.com.svmproj.util.Constant.SEPERATOR_COLON;
import static smv.lovearthstudio.com.svmproj.util.Constant.SEPERATOR_SPACE;
import static smv.lovearthstudio.com.svmproj.util.Util.getChangeRow;

/**
 * Created by zhaoliang on 16/10/2.
 */

public class SVM {

    static int mFeaturesCount;  // 特征数量
    double mScaleLower;  // 归一化的最小值(本项目中使用0,1规划,这个数据来自于train文件的第一行)
    double mScaleUpper;  // 归一化的最大值(本项目中使用0,1规划,这个数据来自于train文件的第一行)
    double[][] mFeaturesData;    // 用来存放每个特征的最大值和最小值
    svm_model mSvmModel;

    /**
     * @param mSvmModel model
     * @param range     range
     */
    public SVM(svm_model mSvmModel, String[] range) {
        this.mSvmModel = mSvmModel;
        mFeaturesCount = range.length - 2;
        String[] lowerAndUpper = range[1].split(SEPERATOR_SPACE);       // 取出归一化的最大值和最小值,这里是0,1规划
        mScaleLower = parseDouble(lowerAndUpper[0]);
        mScaleUpper = parseDouble(lowerAndUpper[1]);
        mFeaturesData = new double[mFeaturesCount][2];

        // 给mFeaturesData赋值
        for (int i = 0; i < mFeaturesCount; i++) {
            String[] featureRange = range[i + 2].split(SEPERATOR_SPACE);    // 每一个特征的最大值和最小值
            mFeaturesData[i][0] = parseDouble(featureRange[1]);
            mFeaturesData[i][1] = parseDouble(featureRange[2]);
        }
    }

    public void setmSvmModel(svm_model mSvmModel) {
        this.mSvmModel = mSvmModel;
    }

    /**
     * 预测样本数据
     *
     * @param unScaleData
     * @return
     */
    public boolean predictUnscaledTrain(String[] unScaleData) {
        return unScaleData[0].equals(String.valueOf(predictUnscaled(unScaleData, true)));
    }

    /**
     * 预测没有规划的数据
     *
     * @param unScaleData
     * @return
     */
    public double predictUnscaled(String[] unScaleData, boolean isSimple) {
        svm_node[] px = new svm_node[mFeaturesCount];
        String[] tempNode = null;
        svm_node p;
        for (int i = 0; i < mFeaturesCount; i++) {
            if (isSimple) {
                tempNode = unScaleData[i + 1].split(SEPERATOR_COLON);
            } else {
                tempNode = unScaleData[i].split(SEPERATOR_COLON);
            }
            p = new svm_node();
            p.index = Integer.parseInt(tempNode[0]);
            p.value = Features.zeroOneLibSvm(mScaleLower, mScaleUpper, parseDouble(tempNode[1]), mFeaturesData[i][0], mFeaturesData[i][1]);
            System.out.println("-----------" + parseDouble(tempNode[1]) + "----------" + p.index + ":" + p.value);
            px[i] = p;
        }
        double v = svm.svm_predict(mSvmModel, px);
        System.out.println("code:" + v);
        return v;
    }

    public static String[] inputStreamToArray(InputStream inputStream) {
        String tempStr = inputStreamToString(inputStream);
        return tempStr.split(getChangeRow());
    }

    /**
     * 数据转换成特征数组
     *
     * @param accArr
     * @return
     */
    public static String[] dataToFeaturesArr(double[] accArr) {
        String[] featuresArr = new String[9];
        double min = Features.minimum(accArr);
        featuresArr[0] = FUN_101_MINIMUM_CODE + ":" + min;
        double max = Features.maximum(accArr);
        featuresArr[1] = FUN_102_MAXIMUM_CODE + ":" + max;
        double var = Features.variance(accArr);
        featuresArr[2] = FUN_103_VARIANCE_CODE + ":" + var;
        double mcr = Features.meanCrossingsRate(accArr);
        featuresArr[3] = FUN_104_MEANCROSSINGSRATE_CODE + ":" + mcr;
        double std = Features.standardDeviation(accArr);
        featuresArr[4] = FUN_105_STANDARDDEVIATION_CODE + ":" + std;
        double mean = Features.mean(accArr);
        featuresArr[5] = FUN_106_MEAN_CODE + ":" + mean;
        double rms = Features.rms(accArr);
        featuresArr[6] = FUN_112_RMS_CODE + ":" + rms;
        double iqr = Features.iqr(accArr);
        featuresArr[7] = FUN_114_IQR_CODE + ":" + iqr;
        double mad = Features.mad(accArr);
        featuresArr[8] = FUN_115_MAD_CODE + ":" + mad;
        return featuresArr;
    }

    /**
     * 把流转换成字符串
     *
     * @param inputStream
     * @return
     */
    private static String inputStreamToString(InputStream inputStream) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            int len = 0;
            byte[] b = new byte[1024];
            while ((len = inputStream.read(b)) != -1) {
                outputStream.write(b, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(outputStream.toByteArray());
    }

}
