package smv.lovearthstudio.com.svmproj.util;

import android.os.Environment;

import java.util.HashMap;
import java.util.Map;

import static java.io.File.separator;

public class Constant {

    public static String dir = Environment.getExternalStorageDirectory() + separator + "机器学习";
    public static String modelFileName = "model";
    public static String rangeFileName = "range";
    public static String trainFileName = "train";
    public static final String SEPERATOR_SPACE = " ";       // 特征分隔符
    public static final String SEPERATOR_COLON = ":";       // lable分隔符
    public static final String train = "traindata";
    public static final String scaleFileName = "scale";
    public static final String resultFileName = "result";
    public static final String modelInfo = "modelInfo";
    public static final String prdictInfo = "prdictInfo";
    public static final String range = "range";

    public static Map<String, Double> actMapToCode = new HashMap<String, Double>();
    public static Map<Double, String> actMapFromCode = new HashMap<Double, String>();
    public static Map<String, Double> wzMapToCode = new HashMap<String, Double>();
    public static Map<Double, String> wzMapFromCode = new HashMap<Double, String>();

    static {
        //行为 ID->Code
        actMapToCode.put("Unknown", 1d);
        actMapToCode.put("Still", 2d);
        actMapToCode.put("Petty action", 3d);
        actMapToCode.put("Walking", 4d);
        actMapToCode.put("Running", 5d);
        actMapToCode.put("Climbing up stairs", 6d);
        actMapToCode.put("Climbing down stairs", 7d);
        actMapToCode.put("Riding up escalator", 8d);
        actMapToCode.put("Riding down escalator", 9d);
        actMapToCode.put("Riding up elevator", 10d);
        actMapToCode.put("Riding down elevator", 11d);
        actMapToCode.put("Sitting & relaxing", 12d);
        actMapToCode.put("WatchingTV", 13d);
        actMapToCode.put("Stretching", 14d);
        actMapToCode.put("Scrubbing", 15d);
        actMapToCode.put("Folding laundry", 16d);
        actMapToCode.put("Brushing teeth", 17d);
        actMapToCode.put("Strength-training", 18d);
        actMapToCode.put("Vacuuming", 19d);
        actMapToCode.put("Lying down & relaxing", 20d);
        actMapToCode.put("Sit-ups", 21d);

        //行为 code->ID
        actMapFromCode.put(1d, "Unknown");
        actMapFromCode.put(2d, "Still");
        actMapFromCode.put(3d, "Petty action");
        actMapFromCode.put(4d, "Walking");
        actMapFromCode.put(5d, "Running");
        actMapFromCode.put(6d, "Climbing up stairs");
        actMapFromCode.put(7d, "Climbing down stairs");
        actMapFromCode.put(8d, "Riding up escalator");
        actMapFromCode.put(9d, "Riding down escalator");
        actMapFromCode.put(10d, "Riding up elevator");
        actMapFromCode.put(11d, "Riding down elevator");
        actMapFromCode.put(12d, "Sitting & relaxing");
        actMapFromCode.put(13d, "WatchingTV");
        actMapFromCode.put(14d, "Stretching");
        actMapFromCode.put(15d, "Scrubbing");
        actMapFromCode.put(16d, "Folding laundry");
        actMapFromCode.put(17d, "Brushing teeth");
        actMapFromCode.put(18d, "Strength-training");
        actMapFromCode.put(18d, "Vacuuming");
        actMapFromCode.put(18d, "Lying down & relaxing");
        actMapFromCode.put(18d, "Sit-ups");

        //位置ID->code
        wzMapToCode.put("Unknown", 1d);
        wzMapToCode.put("Hand Fixed", 2d);
        wzMapToCode.put("Hand Swing", 3d);
        wzMapToCode.put("Pant Pocket", 4d);
        wzMapToCode.put("Back Pocket", 5d);
        wzMapToCode.put("Coat Pocket", 6d);
        wzMapToCode.put("Cheset Pocket", 7d);
        wzMapToCode.put("Shoulder Bag", 8d);
        wzMapToCode.put("Arm Bag", 9d);
        wzMapToCode.put("Hand Bag", 10d);
        wzMapToCode.put("Waist Bag", 11d);
        wzMapToCode.put("Back Bag", 12d);

        //位置code->ID
        wzMapFromCode.put(1d, "Unknown");
        wzMapFromCode.put(2d, "Hand Fixed");
        wzMapFromCode.put(3d, "Hand Swing");
        wzMapFromCode.put(4d, "Pant Pocket");
        wzMapFromCode.put(5d, "Back Pocket");
        wzMapFromCode.put(6d, "Coat Pocket");
        wzMapFromCode.put(7d, "Cheset Pocket");
        wzMapFromCode.put(8d, "Shoulder Bag");
        wzMapFromCode.put(9d, "Arm Bag");
        wzMapFromCode.put(10d, "Hand Bag");
        wzMapFromCode.put(11d, "Waist Bag");
        wzMapFromCode.put(12d, "Back Bag");

    }

    /**
     * 标记为无效 逻辑删除
     **/
    public static final int FLAG_NO = 0;
    /**
     * 标记为有效
     **/
    public static final int FLAG_YES = 1;
    public static final String DUA_URL = "http://115.28.40.128:81/dua/ruleAuthentication";
    /**
     * 经纬度获取seqn
     **/
    public static final String HEXES_URL = "http://hexes.xdua.org/hexes";


    /**
     * ActivityRecognizer的分类索引  未知
     **/
    public static final String ACT_WZ_ID = "Unknown";
    /**
     * ActivityRecognizer的分类索引  未知
     **/
    public static final String ACT_WZ_NAME = "未知";
    public static final double ACT_WZ_CODE = 1;

    /**
     * ActivityRecognizer的分类索引  静止
     **/
    public static final String ACT_JJ_ID = "Still";
    /**
     * ActivityRecognizer的分类索引   静止
     **/
    public static final String ACT_JJ_NAME = "静止";
    public static final double ACT_JJ_CODE = 2;

    /**
     * ActivityRecognizer的分类索引  静立
     **/
    public static final String ACT_JL_ID = "Stationary";
    /**
     * ActivityRecognizer的分类索引   静立
     **/
    public static final String ACT_JL_NAME = "静立";
    public static final double ACT_JL_CODE = 3;

    /**
     * ActivityRecognizer的分类索引  走路
     **/
    public static final String ACT_ZL_ID = "Walking";
    /**
     * ActivityRecognizer的分类索引  走路
     **/
    public static final String ACT_ZL_NAME = "走路";
    public static final double ACT_ZL_CODE = 4;

    /**
     * ActivityRecognizer的分类索引  跑步
     **/
    public static final String PB_ID = "Running";
    /**
     * ActivityRecognizer的分类索引  跑步
     **/
    public static final String ACT_PB_NAME = "跑步";
    public static final double ACT_PB_CODE = 5;

    /**
     * ActivityRecognizer的分类索引  爬楼梯
     **/
    public static final String ACT_PLT_ID = "Climbing up stairs";
    /**
     * ActivityRecognizer的分类索引  爬楼梯
     **/
    public static final String ACT_PLT_NAME = "爬楼梯";
    public static final double ACT_PLT_CODE = 6;

    /**
     * ActivityRecognizer的分类索引  下楼梯
     **/
    public static final String XLT_ID = "Climbing down stairs";
    /**
     * ActivityRecognizer的分类索引  下楼梯
     **/
    public static final String ACT_XLT_NAME = "下楼梯";
    public static final double ACT_XLT_CODE = 7;

    /**
     * ActivityRecognizer的分类索引  乘楼梯上
     **/
    public static final String ACT_CFTD_ID = "Riding down escalator";
    /**
     * ActivityRecognizer的分类索引  乘楼梯上
     **/
    public static final String ACT_CFTD_NAME = "乘扶梯上";
    public static final double ACT_CFTD_CODE = 8;

    /**
     * ActivityRecognizer的分类索引  乘楼梯下
     **/
    public static final String ACT_CFTU_ID = "Riding up elevator";
    /**
     * ActivityRecognizer的分类索引  乘楼梯下
     **/
    public static final String ACT_CFTU_NAME = "乘扶梯下";
    public static final double ACT_CFTU_CODE = 9;

    /**
     * ActivityRecognizer的分类索引  乘电梯上
     **/
    public static final String ACT_CDTD_ID = "Riding up elevator";
    /**
     * ActivityRecognizer的分类索引  乘电梯上
     **/
    public static final String ACT_CDTD_NAME = "乘电梯上";
    public static final double ACT_CDTD_CODE = 10;

    /**
     * ActivityRecognizer的分类索引  乘楼梯下
     **/
    public static final String ACT_CDTU_ID = "Riding down elevator";
    /**
     * ActivityRecognizer的分类索引  乘楼梯下
     **/
    public static final String ACT_CDTU_NAME = "乘电梯下";
    public static final double ACT_CDTU_CODE = 11;

    /**
     * ActivityRecognizer的分类索引  坐着休息
     **/
    public static final String ACT_ZZXX_ID = "Sitting & relaxing";
    /**
     * ActivityRecognizer的分类索引  坐着休息
     **/
    public static final String ACT_ZZXX_NAME = "坐着休息";
    public static final double ACT_ZZXX_CODE = 12;

    /**
     * ActivityRecognizer的分类索引  看电视
     **/
    public static final String ACT_KDS_ID = "WatchingTV";
    /**
     * ActivityRecognizer的分类索引  看电视
     **/
    public static final String ACT_KDS_NAME = "看电视";
    public static final double ACT_KDS_CODE = 13;

    /**
     * ActivityRecognizer的分类索引  伸展
     **/
    public static final String ACT_SZ_ID = "Stretching";
    /**
     * ActivityRecognizer的分类索引  伸展
     **/
    public static final String ACT_SZ_NAME = "伸展";
    public static final double ACT_SZ_CODE = 14;

    /**
     * ActivityRecognizer的分类索引  擦洗
     **/
    public static final String ACT_CX_ID = "Scrubbing";
    /**
     * ActivityRecognizer的分类索引  擦洗
     **/
    public static final String ACT_CX_NAME = "擦洗";
    public static final double ACT_CX_CODE = 15;

    /**
     * ActivityRecognizer的分类索引  叠衣服
     **/
    public static final String ACT_DYF_ID = "Folding laundry";
    /**
     * ActivityRecognizer的分类索引  叠衣服
     **/
    public static final String ACT_DYF_NAME = "叠衣服";
    public static final double ACT_DYF_CODE = 16;

    /**
     * ActivityRecognizer的分类索引  刷牙
     **/
    public static final String ACT_SY_ID = "Brushing teeth";
    /**
     * ActivityRecognizer的分类索引  刷牙
     **/
    public static final String ACT_SY_NAME = "刷牙";
    public static final double ACT_SY_CODE = 17;

    /**
     * ActivityRecognizer的分类索引  伸展训练
     **/
    public static final String ACT_SZXL_ID = "Strength-training";
    /**
     * ActivityRecognizer的分类索引  伸展训练
     **/
    public static final String ACT_SZXL_NAME = "伸展训练";
    public static final double ACT_SZXL_CODE = 18;

    /**
     * ActivityRecognizer的分类索引  用吸尘器扫地
     **/
    public static final String ACT_YXCQSD_ID = "Vacuuming";
    /**
     * ActivityRecognizer的分类索引  用吸尘器扫地
     **/
    public static final String ACT_YXCQSD_NAME = "用吸尘机扫地";
    public static final double ACT_YXCQSD_CODE = 19;

    /**
     * ActivityRecognizer的分类索引  躺着休息
     **/
    public static final String ACT_TZXX_ID = "Lying down & relaxing";
    /**
     * ActivityRecognizer的分类索引  躺着休息
     **/
    public static final String ACT_TZXX_NAME = "躺着休息";
    public static final double ACT_TZXX_CODE = 20;

    /**
     * ActivityRecognizer的分类索引  仰卧起坐
     **/
    public static final String ACT_YWQZ_ID = "Sit-ups";
    /**
     * ActivityRecognizer的分类索引  仰卧起坐
     **/
    public static final String ACT_YWQZ_NAME = "仰卧起坐";
    public static final double ACT_YWQZ_CODE = 21;

    /*位置*/
    public final static String WZ_WZ_ID = "Unknown";
    public final static String WZ_WZ_NAME = "未知";
    public final static double WZ_WZ_CODE = 1;
    public final static String WZ_SGD_ID = "Hand Fixed";
    public final static String WZ_SGD_NAME = "手固定";
    public final static double WZ_SGD_CODE = 2;
    public final static String WZ_SBD_ID = "Hand Swing";
    public final static String WZ_SBD_NAME = "手摆动";
    public final static double WZ_SBD_CODE = 3;
    public final static String WZ_KD_ID = "Pant Pocket";
    public final static String WZ_KD_NAME = "裤兜";
    public final static double WZ_KD_CODE = 4;
    public final static String WZ_PGD_ID = "Back Pocket";
    public final static String WZ_PGD_NAME = "屁股兜";
    public final static double WZ_PGD_CODE = 5;
    public final static String WZ_YD_ID = "Coat Pocket";
    public final static String WZ_YD_NAME = "衣兜";
    public final static double WZ_YD_CODE = 6;
    public final static String WZ_XD_ID = "Cheset Pocket";
    public final static String WZ_XD_NAME = "胸兜";
    public final static double WZ_XD_CODE = 7;
    public final static String WZ_JB_ID = "Shoulder Bag";
    public final static String WZ_JB_NAME = "肩包";
    public final static double WZ_JB_CODE = 8;
    public final static String WZ_KB_ID = "Arm Bag";
    public final static String WZ_KB_NAME = "挎包";
    public final static double WZ_KB_CODE = 9;
    public final static String WZ_TB_ID = "Hand Bag";
    public final static String WZ_TB_NAME = "提包";
    public final static double WZ_TB_CODE = 10;
    public final static String WZ_YB_ID = "Waist Bag";
    public final static String WZ_YB_NAME = "腰包";
    public final static double WZ_YB_CODE = 11;
    public final static String WZ_BB_ID = "Back Bag";
    public final static String WZ_BB_NAME = "背包";
    public final static double WZ_BB_CODE = 12;

	/*函数名*/
    /**
     * 最小值 min
     **/
    public static final String FUN_101_MINIMUM_NAME = "min";
    public static final int FUN_101_MINIMUM_CODE = 101;
    /**
     * 最大值 max
     **/
    public static final String FUN_102_MAXIMUM_NAME = "max";
    public static final int FUN_102_MAXIMUM_CODE = 102;
    /**
     * 方差 variance
     **/
    public static final String FUN_103_VARIANCE_NAME = "variance";
    public static final int FUN_103_VARIANCE_CODE = 103;
    /**
     * 过均值率 mcr
     **/
    public static final String FUN_104_MEANCROSSINGSRATE_NAME = "mcr";
    public static final int FUN_104_MEANCROSSINGSRATE_CODE = 104;
    /**
     * 标准差 stddev
     **/
    public static final String FUN_105_STANDARDDEVIATION_NAME = "stddev";
    public static final int FUN_105_STANDARDDEVIATION_CODE = 105;
    /**
     * 平均值 mean
     **/
    public static final String FUN_106_MEAN_NAME = "mean";
    public static final int FUN_106_MEAN_CODE = 106;
    /**
     * 向量幅值 mag
     **/
    public static final String FUN_107_SIGNALVECTORMAGNITUDE_NAME = "mag";
    public static final int FUN_107_SIGNALVECTORMAGNITUDE_CODE = 107;
    /**
     * 四分卫数 1/4 q1
     **/
    public static final String FUN_108_FIRSTQUARTILE_NAME = "q1";
    public static final int FUN_108_FIRSTQUARTILE_CODE = 108;
    /**
     * 中位数 median
     **/
    public static final String FUN_109_MEDIAN_NAME = "median";
    public static final int FUN_109_MEDIAN_CODE = 109;
    /**
     * 四分卫数 3/4 q3
     **/
    public static final String FUN_110_THIRDQUARTILE_NAME = "q3";
    public static final int FUN_110_THIRDQUARTILE_CODE = 110;
    /**
     * 过零率 zcr
     **/
    public static final String FUN_111_ZEROCROSSINGRATE_NAME = "zcr";
    public static final int FUN_111_ZEROCROSSINGRATE_CODE = 111;
    /**
     * 均方根平均值 rms
     **/
    public static final String FUN_112_RMS_NAME = "rms";
    public static final int FUN_112_RMS_CODE = 112;
    /**
     * 向量幅值面积 sma
     **/
    public static final String FUN_113_SMA_NAME = "sma";
    public static final int FUN_113_SMA_CODE = 113;
    /**
     * 四分卫距 iqr
     **/
    public static final String FUN_114_IQR_NAME = "iqr";
    public static final int FUN_114_IQR_CODE = 114;
    /**
     * 绝对平均差 mad
     **/
    public static final String FUN_115_MAD_NAME = "mad";
    public static final int FUN_115_MAD_CODE = 115;
    /**
     * 时域 能量 tenergy
     **/
    public static final String FUN_116_TENERGY_NAME = "tenergy";
    public static final int FUN_116_TENERGY_CODE = 116;


    /**
     * spp最大值的位置 谱峰位置
     **/
    public static final String FUN_201_SPP_NAME = "spp";
    public static final int FUN_201_SPP_CODE = 201;
    /**
     * 能量 energy
     **/
    public static final String FUN_202_ENERGY_NAME = "energy";
    public static final int FUN_202_ENERGY_CODE = 202;
    /**
     * 熵 entropy
     **/
    public static final String FUN_203_ENTROPY_NAME = "entropy";
    public static final int FUN_203_ENTROPY_CODE = 203;
    /**
     * 质心 centroid
     **/
    public static final String FUN_204_CENTROID_NAME = "centroid";
    public static final int FUN_204_CENTROID_CODE = 204;
    /**
     * 频域 标准差 fdev
     **/
    public static final String FUN_205_FDEV_NAME = "fdev";
    public static final int FUN_205_FDEV_CODE = 205;
    /**
     * 频域 平均值 fmean
     **/
    public static final String FUN_206_FMEAN_NAME = "fmean";
    public static final int FUN_206_FMEAN_CODE = 206;
    /**
     * 频域 偏度 skew
     **/
    public static final String FUN_207_SKEW_NAME = "skew";
    public static final int FUN_207_SKEW_CODE = 207;
    /**
     * 频域 峰度 kurt
     **/
    public static final String FUN_208_KURT_NAME = "kurt";
    public static final int FUN_208_KURT_CODE = 208;

	/*模型类型*/
    /**
     * accdata 行为模型
     **/
    public static final String MODELTYPE_ACCDATA = "accdata";


    public static final int PAGEOFSIZE = 10;
}
