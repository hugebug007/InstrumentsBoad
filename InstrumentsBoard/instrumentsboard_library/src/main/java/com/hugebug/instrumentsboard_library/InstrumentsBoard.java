package com.hugebug.instrumentsboard_library;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;

/**
 * test neetspeed
 *
 * 仪表板
 *
 * @author lzg
 *
 */
public class InstrumentsBoard extends View {
    private final float ZORESCAL = 150f;// 相对0刻度点
    private final int ZORE = 0;

    private float firstLabel = -40;
    private float secondLabel = -20;
    private float thirdLabel = 0;
    private float fourthLabel = 10;
    private float fifthLabel = 20;
    private float sixthLabel = 30;
    private float seventhLabel = 40;
    private float eighthLabel = 60;
    private float ninthLabel = 80;

    /*
     * 温度
     */
    private final int TEMP_ZORE = -40;
    private final int TEMP_FIRST_STALL = -20;
    private final int TEMP_SECOND_STALL = 0;
    private final int TEMP_THIRD_STALL = 10;
    private final int TEMP_FOURTH_STALL = 20;
    private final int TEMP_FIFTH_STALL = 30;
    private final int TEMP_SIXTH_STALL = 40;
    private final int TEMP_SEVENTH_STALL = 60;
    private final int TEMP_EIGHTH_STALL = 80;
    /*
     * 湿度、水分
     */
    private final int HUM_ZORE = 0;
    private final int HUM_FIRST_STALL = 10;
    private final int HUM_SECOND_STALL = 20;
    private final int HUM_THIRD_STALL = 30;
    private final int HUM_FOURTH_STALL = 40;
    private final int HUM_FIFTH_STALL = 50;
    private final int HUM_SIXTH_STALL = 60;
    private final int HUM_SEVENTH_STALL = 80;
    private final int HUM_EIGHTH_STALL = 100;

    /*
     * 光照
     */
    private final int SHINE_ZORE = 0;
    private final int SHINE_FIRST_STALL = 1000;
    private final int SHINE_SECOND_STALL = 2000;
    private final int SHINE_THIRD_STALL = 5000;
    private final int SHINE_FOURTH_STALL = 10000;
    private final int SHINE_FIFTH_STALL = 20000;
    private final int SHINE_SIXTH_STALL = 50000;
    private final int SHINE_SEVENTH_STALL = 100000;
    private final int SHINE_EIGHTH_STALL = 200000;

    /*
     * CO2
     */
    private final int CO2_ZORE = 0;
    private final int CO2_FIRST_STALL = 200;
    private final int CO2_SECOND_STALL = 500;
    private final int CO2_THIRD_STALL = 1000;
    private final int CO2_FOURTH_STALL = 2000;
    private final int CO2_FIFTH_STALL = 5000;
    private final int CO2_SIXTH_STALL = 10000;
    private final int CO2_SEVENTH_STALL = 30000;
    private final int CO2_EIGHTH_STALL = 60000;

    /*
     * ECS电导率
     */

    private final float EC_ZORE = 0;
    private final float EC_FIRST_STALL = 2;
    private final float EC_SECOND_STALL = 4;
    private final float EC_THIRD_STALL = 6;
    private final float EC_FOURTH_STALL = 8;
    private final float EC_FIFTH_STALL = 10;
    private final float EC_SIXTH_STALL = 12;
    private final float EC_SEVENTH_STALL = 15;
    private final float EC_EIGHTH_STALL = 20;

    /*
     * SOILYS 盐分
     */

    private final float SOILYS_ZORE = 0;
    private final float SOILYS_FIRST_STALL = 0.01f;
    private final float SOILYS_SECOND_STALL = 0.02f;
    private final float SOILYS_THIRD_STALL = 0.03f;
    private final float SOILYS_FOURTH_STALL = 0.04f;
    private final float SOILYS_FIFTH_STALL = 0.05f;
    private final float SOILYS_SIXTH_STALL = 0.07f;
    private final float SOILYS_SEVENTH_STALL = 0.1f;
    private final float SOILYS_EIGHTH_STALL = 0.15f;

    /*
     * 速度
     */
    private final float SPEED_ZORE = 0;
    private final float SPEED_FIRST_STALL = 30;
    private final float SPEED_SECOND_STALL = 60;
    private final float SPEED_THIRD_STALL = 90;
    private final float SPEED_FOURTH_STALL = 120;
    private final float SPEED_FIFTH_STALL = 150;
    private final float SPEED_SIXTH_STALL = 180;
    private final float SPEED_SEVENTH_STALL = 210;
    private final float SPEED_EIGHTH_STALL = 240;




    private final int STEP_DEGREE = 30;// 每个大格子的角度

    private final int CHANGE_ALL_STEPS = 60;// 每次变化时使用的绘制步数

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    // 旋转的度数
    private double mDegrees = 1;
    private Matrix mMatrix = new Matrix();
    private Double testValue;
    // Bitmap auto_pointer;// 指针
    Bitmap auto_dashdoard;// 刻度面板
    Resources res = getResources();
    private double stepValue;// 步进度数
    private double dstDegrees;// 目标度数
    private boolean getDst = false;// 到达目标值的信号
    private Context context;
    private float rectWihPx = 0;
    private float viewWithPx;
    private float actionBarHeight;
    private float statuHeight;
    private float screenWithPx;
    private float dashdoardWithHalf;
    /** The width of the view */
    private int width;
    /** The height of the view */
    private int height;
    /** The circle's center X coordinate of Matrix */
    private float cx;
    /** The circle's center Y coordinate of Matrix */
    private float cy;
    /** The left bound for the circle RectF */
    private float left;
    /** The right bound for the circle RectF */
    private float right;
    /** The top bound for the circle RectF */
    private float top;
    /** The bottom bound for the circle RectF */
    private float bottom;

    private float radius;

    // /**
    // * The RectF of dashRectF
    // */
    // private RectF dashRectF = new RectF();
    /**
     * The RectF of pointRectF
     */
    private RectF pointRectF = new RectF();

    private RectF innerCircleRectF = new RectF();

    // private RectF textRectF = new RectF();

    /** The color of the progress ring */
    private Paint circleColor;

    private Paint innerCirclePaint = null;

    private Paint testPaint = null;

    private byte testMode = TestMeterCommon.SPEED;
    private float mDensity;
    private String[] temps = new String[] { "-40℃", "-20℃", "0℃", "10℃", "20℃", "30℃", "40℃", "60℃", "80℃" };

    private String[] hums = new String[] { "0%", "10%", "20%", "30%", "40%", "50%", "60%", "80%", "100%" };

    private String[] shines = new String[] { "0lux", "1Klux", "2Klux", "5Klux", "10Klux", "20Klux", "50Klux", "100Klux",
            "200Klux" };

    private String[] ppms = new String[] { "0ppm", "200ppm", "500ppm", "1Kppm", "2Kppm", "5Kppm", "10Kppm", "30Kppm",
            "60Kppm" };

    private String[] ECS = new String[] { "0mS/cm", "2mS/cm", "4mS/cm", "6mS/cm", "8mS/cm", "10mS/cm", "12mS/cm",
            "15mS/cm", "20mS/cm" };

    private String[] soilys = new String[] { "0mol/L", "0.01mol/L", "0.02mol/L", "0.03mol/L", "0.04mol/L", "0.05mol/L",
            "0.07mol/L", "0.10mol/L", "0.15mol/L" };
    private String[] speeds = new String[] { "0km/h", "30km/h", "60km/h", "90km/h", "120km/h", "150km/h",
            "180km/h", "210km/h", "240km/h" };

    private String unit = "km/h";

    private String testModeDes = "速度";

    private String showValue = "000";

    private int labelId = 0;

    private Paint drawScaleTestPaint;


    public float getActionBarHeight() {
        return actionBarHeight;
    }

    public void setActionBarHeight(float actionBarHeight) {
        this.actionBarHeight = actionBarHeight;
    }

    public InstrumentsBoard(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.context = context;
        mPaint.setAntiAlias(true);
        initDrawable();
    }

    public InstrumentsBoard(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.context = context;
        mPaint.setAntiAlias(true);
        initDrawable();
    }

    public InstrumentsBoard(Context context) {
        super(context);
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.context = context;
        mPaint.setAntiAlias(true);
        initDrawable();
    }

    private void initDrawable() {
        // initDashDoard(testMode);
        circleColor = new Paint();
        circleColor.setColor(Color.parseColor("#ff33b5e5")); // Set default

        innerCirclePaint = new Paint();
        innerCirclePaint.setColor(Color.parseColor("#ffffffff"));

        testPaint = new Paint();
        testPaint.setColor(Color.parseColor("#FFF8AD8E"));

    }



    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        width = getWidth(); // Get View Width
        height = getHeight();// Get View Height
        int size = (width > height) ? height : width; // Choose the smaller
        dashdoardWithHalf = size / 2;
        cx = width / 2;
        cy = height / 2+10*mDensity;
        radius = size / 2;
        // float imgWith = auto_dashdoard.getWidth();
        // float imgheight = auto_dashdoard.getHeight();
        // float recfWith = imgWith/imgheight*size;
        //
        // float recfHeight = imgheight/imgWith * recfWith;

        // left = cx - recfWith/2;
        // right = cx + recfWith/2;
        // top = cy - recfHeight/2;
        // bottom = cy + recfHeight/2;
        // dashRectF.set(left, top, right, bottom);

        float leftF = cx - radius * 0.55f;
        float rightF = cx + dashdoardWithHalf * 0.55f;
        float topF = cy - dashdoardWithHalf * 0.55f;
        float bottomF = cy + dashdoardWithHalf * 0.55f;
        pointRectF.set(leftF, topF, rightF, bottomF);

        float innerLeftF = cx - radius * 0.5f;
        float innerRightF = cx + dashdoardWithHalf * 0.5f;
        float innerTopF = cy - dashdoardWithHalf * 0.5f;
        float innerBottomF = cy + dashdoardWithHalf * 0.5f;
        innerCircleRectF.set(innerLeftF, innerTopF, innerRightF, innerBottomF);
        canvas.drawColor(Color.argb(0, 0, 0, 0));
        // drawDashdoard(canvas);

        drawScale(canvas);
        drawScaleText(canvas, testMode);

        drawPoint(canvas);
        drawInnerCircle(canvas);
        drawTestView(canvas, showValue);
        drawTestMode(canvas, testModeDes);
        super.onDraw(canvas);

    }


    public void switchTestMode(byte testMode) {
        switch (testMode) {
            case TestMeterCommon.TEMP:
                unit = "°C";
                testModeDes = "温度";
                firstLabel = TEMP_ZORE;
                secondLabel = TEMP_FIRST_STALL;
                thirdLabel = TEMP_SECOND_STALL;
                fourthLabel = TEMP_THIRD_STALL;
                fifthLabel = TEMP_FOURTH_STALL;
                sixthLabel = TEMP_FIFTH_STALL;
                seventhLabel = TEMP_SIXTH_STALL;
                eighthLabel = TEMP_SEVENTH_STALL;
                ninthLabel = TEMP_EIGHTH_STALL;
                break;
            case TestMeterCommon.SOIL_TEMP:
                unit = "°C";
                testModeDes = "土壤温度";
                firstLabel = TEMP_ZORE;
                secondLabel = TEMP_FIRST_STALL;
                thirdLabel = TEMP_SECOND_STALL;
                fourthLabel = TEMP_THIRD_STALL;
                fifthLabel = TEMP_FOURTH_STALL;
                sixthLabel = TEMP_FIFTH_STALL;
                seventhLabel = TEMP_SIXTH_STALL;
                eighthLabel = TEMP_SEVENTH_STALL;
                ninthLabel = TEMP_EIGHTH_STALL;
                break;
            case TestMeterCommon.HUM:
                unit = "%";
                testModeDes = "湿度";
                firstLabel = HUM_ZORE;
                secondLabel = HUM_FIRST_STALL;
                thirdLabel = HUM_SECOND_STALL;
                fourthLabel = HUM_THIRD_STALL;
                fifthLabel = HUM_FOURTH_STALL;
                sixthLabel = HUM_FIFTH_STALL;
                seventhLabel = HUM_SIXTH_STALL;
                eighthLabel = HUM_SEVENTH_STALL;
                ninthLabel = HUM_EIGHTH_STALL;
                break;
            case TestMeterCommon.SOIL_WATER:
                unit = "%";
                testModeDes = "土壤水分";
                firstLabel = HUM_ZORE;
                secondLabel = HUM_FIRST_STALL;
                thirdLabel = HUM_SECOND_STALL;
                fourthLabel = HUM_THIRD_STALL;
                fifthLabel = HUM_FOURTH_STALL;
                sixthLabel = HUM_FIFTH_STALL;
                seventhLabel = HUM_SIXTH_STALL;
                eighthLabel = HUM_SEVENTH_STALL;
                ninthLabel = HUM_EIGHTH_STALL;
                break;
            case TestMeterCommon.SUN_SHINE:
                unit = "lux";
                testModeDes = "光照";
                firstLabel = SHINE_ZORE;
                secondLabel = SHINE_FIRST_STALL;
                thirdLabel = SHINE_SECOND_STALL;
                fourthLabel = SHINE_THIRD_STALL;
                fifthLabel = SHINE_FOURTH_STALL;
                sixthLabel = SHINE_FIFTH_STALL;
                seventhLabel = SHINE_SIXTH_STALL;
                eighthLabel = SHINE_SEVENTH_STALL;
                ninthLabel = SHINE_EIGHTH_STALL;
                break;
            case TestMeterCommon.CO2:
                unit = "ppm";
                testModeDes = "CO2";
                firstLabel = CO2_ZORE;
                secondLabel = CO2_FIRST_STALL;
                thirdLabel = CO2_SECOND_STALL;
                fourthLabel = CO2_THIRD_STALL;
                fifthLabel = CO2_FOURTH_STALL;
                sixthLabel = CO2_FIFTH_STALL;
                seventhLabel = CO2_SIXTH_STALL;
                eighthLabel = CO2_SEVENTH_STALL;
                ninthLabel = CO2_EIGHTH_STALL;
                break;
            case TestMeterCommon.EC:
                unit = "mS/cm";
                testModeDes = "土壤电导率";
                firstLabel = EC_ZORE;
                secondLabel = EC_FIRST_STALL;
                thirdLabel = EC_SECOND_STALL;
                fourthLabel = EC_THIRD_STALL;
                fifthLabel = EC_FOURTH_STALL;
                sixthLabel = EC_FIFTH_STALL;
                seventhLabel = EC_SIXTH_STALL;
                eighthLabel = EC_SEVENTH_STALL;
                ninthLabel = EC_EIGHTH_STALL;
                break;
            case TestMeterCommon.SALTY:
                unit = "mol/L";
                testModeDes = "土壤盐分";
                firstLabel = SOILYS_ZORE;
                secondLabel = SOILYS_FIRST_STALL;
                thirdLabel = SOILYS_SECOND_STALL;
                fourthLabel = SOILYS_THIRD_STALL;
                fifthLabel = SOILYS_FOURTH_STALL;
                sixthLabel = SOILYS_FIFTH_STALL;
                seventhLabel = SOILYS_SIXTH_STALL;
                eighthLabel = SOILYS_SEVENTH_STALL;
                ninthLabel = SOILYS_EIGHTH_STALL;
                break;

            case TestMeterCommon.SPEED:
                unit = TestMeterCommon.SPEED_UNIT;
                testModeDes = "速度";
                firstLabel = SPEED_ZORE;
                secondLabel = SPEED_FIRST_STALL;
                thirdLabel = SPEED_SECOND_STALL;
                fourthLabel = SPEED_THIRD_STALL;
                fifthLabel = SPEED_FOURTH_STALL;
                sixthLabel = SPEED_FIFTH_STALL;
                seventhLabel = SPEED_SIXTH_STALL;
                eighthLabel = SPEED_SEVENTH_STALL;
                ninthLabel = SPEED_EIGHTH_STALL;
                break;
        }
    }

    /**
     * 绘制指针
     *
     * @param canvas
     */
    private void drawPoint(Canvas canvas) {
        switchTestMode(testMode);
        // if(mDegrees == 0)
        // mDegrees = 200;
        circleColor.setAntiAlias(true);
//		SweepGradient sg = new SweepGradient(cx, cy, Color.parseColor("#FE9614"), Color.parseColor("#FF48C3"));

        int[] colors = new int[] { Color.parseColor("#FE9614"), Color.parseColor("#FF48C3"),
                Color.parseColor("#FF0000"), Color.parseColor("#28004d") };
        float[] positions = new float[] { 0, 1, 2, 3 };
        SweepGradient sg1 = new SweepGradient(cx, cy, colors, positions);

        circleColor.setShader(sg1);
        canvas.drawArc(pointRectF, ZORESCAL, (float) mDegrees, true, circleColor);

        /* 解除画布的锁定 */
        // canvas.restore();
        if (!getDst)
            // 获取每次步进的度数
            stepValue = (dstDegrees - mDegrees) / CHANGE_ALL_STEPS;

        // 正时针旋转
        if (stepValue > ZORE && !getDst) {
            if (mDegrees < dstDegrees) {
                mDegrees = mDegrees + 4 * stepValue;

                getDst = false;
            }
            if (mDegrees >= dstDegrees - 0.1) {
                mDegrees = dstDegrees;
                getDst = true;
                stepValue = 0;
            }
        }
        // 逆时针旋转
        if (stepValue < ZORE && !getDst) {
            if (mDegrees > dstDegrees) {
                mDegrees = mDegrees + 4 * stepValue;
                getDst = false;
            }
            if (mDegrees <= dstDegrees + 0.1) {
                mDegrees = dstDegrees;
                getDst = true;
                stepValue = 0;

            }
        }
        showValue = getVlaueByDegree(mDegrees);
        invalidate();
    }

    private void drawInnerCircle(Canvas canvas) {
        innerCirclePaint.setAntiAlias(true);

        // canvas.drawCircle(cx, cy, radius * 0.6F, innerCirclePaint);
        canvas.drawArc(innerCircleRectF, 0, 360, true, innerCirclePaint);
    }

    /**
     * 画测量值
     *
     * @param canvas
     * @param text
     */
    private void drawTestView(Canvas canvas, String text) {
        if (text != null && !"".equals(text)) {
            Rect rect = new Rect();
            Rect rectUnit = new Rect();
            testPaint.setFakeBoldText(true);

            testPaint.setTextSize(16 * mDensity);
            testPaint.getTextBounds(text, 0, text.length(), rect);

            testPaint.getTextBounds(unit, 0, unit.length(), rectUnit);

            testPaint.setColor(Color.parseColor("#FE892C"));
            canvas.drawText(text, cx - (rect.width() + rectUnit.width() + 5) / 2, cy + rect.height() / 2, testPaint);
            testPaint.setColor(Color.parseColor("#FF4ABF"));
            canvas.drawText(unit, cx - (rect.width() + rectUnit.width()) / 2 + rect.width() + 5, cy + rect.height() / 2,
                    testPaint);

        }
    }

    /**
     * 画测试类型
     *
     * @param canvas
     * @param text
     */
    private void drawTestMode(Canvas canvas, String text) {
        Rect rect = new Rect();
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#20c0f4"));

        paint.setTextSize(18 * mDensity);
        paint.getTextBounds(text, 0, text.length(), rect);

        int rectWith = rect.width();
        int rectHight = rect.height();
        int left = (int) (cx - rectWith / 2 - 10);
        int right = (int) (cx + rectWith / 2 + 10);
        int top = (int) (cy - rectHight / 2 + 130 - 10);
        int bottom = (int) (cy + rectHight / 2 + 130 + 10);
        Rect rectD = new Rect(left, top, right, bottom);

        canvas.drawRect(rectD, paint);

        paint.setColor(Color.parseColor("#ffffff"));
        paint.setFakeBoldText(true);
        canvas.drawText(text, cx - rect.width() / 2, cy + 142, paint);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mDensity = context.getResources().getDisplayMetrics().density;
        width = getWidth(); // Get View Width
        height = getHeight();// Get View Height
        int size = (width > height) ? height : width; // Choose the smaller
        dashdoardWithHalf = size / 2;
        cx = width / 2;
        cy = height / 2+10*mDensity;
        radius = size / 2;
        // float imgWith = auto_dashdoard.getWidth();
        // float imgheight = auto_dashdoard.getHeight();
        // float recfWith = imgWith/imgheight*size;
        //
        // float recfHeight = imgheight/imgWith * recfWith;

        // left = cx - recfWith/2;
        // right = cx + recfWith/2;
        // top = cy - recfHeight/2;
        // bottom = cy + recfHeight/2;
        // dashRectF.set(left, top, right, bottom);

        float leftF = cx - radius * 0.55f;
        float rightF = cx + dashdoardWithHalf * 0.55f;
        float topF = cy - dashdoardWithHalf * 0.55f;
        float bottomF = cy + dashdoardWithHalf * 0.55f;
        pointRectF.set(leftF, topF, rightF, bottomF);

        float innerLeftF = cx - radius * 0.5f;
        float innerRightF = cx + dashdoardWithHalf * 0.5f;
        float innerTopF = cy - dashdoardWithHalf * 0.5f;
        float innerBottomF = cy + dashdoardWithHalf * 0.5f;
        innerCircleRectF.set(innerLeftF, innerTopF, innerRightF, innerBottomF);
    }

    /**
     * 设置仪表值
     *
     * @param testValue
     */
    public void setTestValue(double testValue) {
        this.getDst = false;
        this.testValue = testValue;
        this.dstDegrees = getDstDegreesByNeetSeep();

    }

    /**
     * 根据度数获取值
     *
     * @param degree
     * @return
     */
    private String getVlaueByDegree(double degree) {
        switchTestMode(testMode);
        Double value = 0d;
        String showValue = "";
        if (degree >= ZORE && degree < STEP_DEGREE) {
            value = firstLabel + degree * (secondLabel - firstLabel) / STEP_DEGREE;
        } else if (degree >= STEP_DEGREE && degree < 2 * STEP_DEGREE) {
            value = secondLabel + (degree - STEP_DEGREE) * (thirdLabel - secondLabel) / STEP_DEGREE;
        } else if (degree >= 2 * STEP_DEGREE && degree < 3 * STEP_DEGREE) {
            value = thirdLabel + (degree - 2 * STEP_DEGREE) * (fourthLabel - thirdLabel) / STEP_DEGREE;
        } else if (degree >= 3 * STEP_DEGREE && degree < 4 * STEP_DEGREE) {
            value = fourthLabel + (degree - 3 * STEP_DEGREE) * (fifthLabel - fourthLabel) / STEP_DEGREE;
        } else if (degree >= 4 * STEP_DEGREE && degree < 5 * STEP_DEGREE) {
            value = fifthLabel + (degree - 4 * STEP_DEGREE) * (sixthLabel - fifthLabel) / STEP_DEGREE;
        } else if (degree >= 5 * STEP_DEGREE && degree < 6 * STEP_DEGREE) {
            value = sixthLabel + (degree - 5 * STEP_DEGREE) * (seventhLabel - sixthLabel) / STEP_DEGREE;
        } else if (degree >= 6 * STEP_DEGREE && degree < 7 * STEP_DEGREE) {
            value = seventhLabel + (degree - 6 * STEP_DEGREE) * (eighthLabel - seventhLabel) / STEP_DEGREE;
        } else if (degree >= 7 * STEP_DEGREE && degree < 8 * STEP_DEGREE) {
            value = eighthLabel + (degree - 7 * STEP_DEGREE) * (ninthLabel - eighthLabel) / STEP_DEGREE;
        } else {
            value = (double) ninthLabel;
        }
        switch (testMode) {
            case TestMeterCommon.TEMP:
            case TestMeterCommon.SOIL_TEMP:
            case TestMeterCommon.HUM:
            case TestMeterCommon.SOIL_WATER:
            case TestMeterCommon.EC:
                showValue = Double.toString(Utils.getDoubleNumber(value, 2));
                break;
            case TestMeterCommon.SUN_SHINE:
            case TestMeterCommon.CO2:
                showValue = Integer.toString(Utils.getIntNumber(value));
                break;
            case TestMeterCommon.SALTY:
                showValue = Double.toString(Utils.getDoubleNumber(value, 4));
                break;
            case TestMeterCommon.SPEED:
                showValue = Double.toString(Utils.getIntNumber(value));
                break;

            default:
                break;
        }
        return showValue;
    }

    /**
     * 根据值获取旋转角度
     *
     * @return
     */
    private double getDstDegreesByNeetSeep() {
        switchTestMode(testMode);

        Double dstDegree = 0d;
        if (testValue >= firstLabel && testValue < secondLabel) {
            dstDegree = (testValue - firstLabel) * STEP_DEGREE / (secondLabel - firstLabel);
        } else if (testValue >= secondLabel && testValue < thirdLabel) {
            dstDegree = STEP_DEGREE + (testValue - secondLabel) * STEP_DEGREE / (thirdLabel - secondLabel);
        } else if (testValue >= thirdLabel && testValue < fourthLabel) {
            dstDegree = 2 * STEP_DEGREE + (testValue - thirdLabel) * STEP_DEGREE / (fourthLabel - thirdLabel);
        } else if (testValue >= fourthLabel && testValue < fifthLabel) {
            dstDegree = 3 * STEP_DEGREE + (testValue - fourthLabel) * STEP_DEGREE / (fifthLabel - fourthLabel);
        } else if (testValue >= fifthLabel && testValue < sixthLabel) {
            dstDegree = 4 * STEP_DEGREE + (testValue - fifthLabel) * STEP_DEGREE / (sixthLabel - fifthLabel);
        } else if (testValue >= sixthLabel && testValue < seventhLabel) {
            dstDegree = 5 * STEP_DEGREE + (testValue - sixthLabel) * STEP_DEGREE / (seventhLabel - sixthLabel);
        } else if (testValue >= seventhLabel && testValue < eighthLabel) {
            dstDegree = 6 * STEP_DEGREE + (testValue - seventhLabel) * STEP_DEGREE / (eighthLabel - seventhLabel);
        } else if (testValue >= eighthLabel && testValue < ninthLabel) {
            dstDegree = 7 * STEP_DEGREE + (testValue - eighthLabel) * STEP_DEGREE / (ninthLabel - eighthLabel);
        } else {
            dstDegree = 8d * STEP_DEGREE;
        }
        return dstDegree;
    }

    public byte getTestMode() {
        return testMode;
    }

    public void setTestMode(byte testMode) {
        this.testMode = testMode;
        // initDashDoard(testMode);
        invalidate();
    }

    public int getLabelId() {
        return labelId;
    }

    public void setLabelId(int labelId) {
        this.labelId = labelId;
        auto_dashdoard = BitmapFactory.decodeResource(context.getResources(), labelId);
        invalidate();
    }

    /**
     * 绘制刻度
     */
    private void drawScale(Canvas canvas) {
        float x = (float) (cx + 0.7 * radius * Math.cos(5 * Math.PI / 6f));
        float y = (float) (cy + 0.7 * radius * Math.sin(5 * Math.PI / 6f));

        float endX = (float) (cx + (0.7 * radius - 16) * Math.cos(5 * Math.PI / 6f));
        float endY = (float) (cy + (0.7 * radius - 16) * Math.sin(5 * Math.PI / 6f));

        mPaint.setColor(Color.parseColor("#06A8CA"));
        mPaint.setStrokeWidth(6);
        mPaint.setStrokeCap(Cap.ROUND);
        for (int i = 0; i < 41; i++) {
            if (i % 5 == 0) {
                canvas.drawLine(x, y, endX, endY, mPaint);

                float xline = (float) (cx + 0.82 * radius * Math.cos(5 * Math.PI / 6f));
                float yline = (float) (cy + 0.82 * radius * Math.sin(5 * Math.PI / 6f));

                float endXLine = (float) (cx + (0.81 * radius - 0.06 * radius) * Math.cos(5 * Math.PI / 6f));
                float endYLine = (float) (cy + (0.81 * radius - 0.06 * radius) * Math.sin(5 * Math.PI / 6f));

                canvas.drawLine(xline, yline, endXLine, endYLine, mPaint);

            } else {
                canvas.drawLine(x, y, endX, endY, mPaint);
            }
            canvas.rotate(6, cx, cy);
        }
        canvas.rotate((float) (360 - 41 * 6), cx, cy);
    }

    /**
     * 绘制速度标识文字
     */
    private void drawScaleText(Canvas canvas, byte testMode) {
        String[] scaleTests = null;
        switch (testMode) {
            case TestMeterCommon.TEMP:
            case TestMeterCommon.SOIL_TEMP:
                scaleTests = temps;
                break;
            case TestMeterCommon.HUM:
            case TestMeterCommon.SOIL_WATER:
                scaleTests = hums;
                break;
            case TestMeterCommon.SUN_SHINE:
                scaleTests = shines;
                break;
            case TestMeterCommon.CO2:
                scaleTests = ppms;
                break;
            case TestMeterCommon.EC:
                scaleTests = ECS;
                break;
            case TestMeterCommon.SALTY:
                scaleTests = soilys;
                break;
            case TestMeterCommon.SPEED:
                scaleTests = speeds;
                break;
            default:
                scaleTests = speeds;
                break;
        }

        if (scaleTests != null) {
            for (int i = 0; i < scaleTests.length; i++) {
                String text = scaleTests[i];
                if (text != null && !"".equals(text)) {
                    Rect rect = new Rect();
                    if(drawScaleTestPaint == null){
                        drawScaleTestPaint = new Paint();
                    }

                    drawScaleTestPaint.setColor(Color.parseColor("#06A8CA"));
                    // paint.setTextSize(10);
                    drawScaleTestPaint.setFakeBoldText(true);

                    drawScaleTestPaint.setTextSize(14 * mDensity);

                    drawScaleTestPaint.getTextBounds(text, 0, text.length(), rect);
//					int index = 8;
                    // 速度文字 绘制的XY坐标
                    int baseX = 0, baseY = 0;
                    switch (i) {
                        case 0:
                            // 计算Baseline绘制的起点X轴坐标
                            baseX = (int) (cx - 0.83 * radius * Math.cos(1 * Math.PI / 6f) - rect.width() - 10);
                            // 计算Baseline绘制的Y坐标
                            baseY = (int) (cy + 0.83 * radius * Math.sin(1 * Math.PI / 6f) + rect.height() / 2);
                            break;
                        case 1:
                            // 计算Baseline绘制的起点X轴坐标
                            baseX = (int) (cx - 0.83 * radius * Math.cos(0 * Math.PI / 6f) - rect.width() - 10);
                            // 计算Baseline绘制的Y坐标
                            baseY = (int) (cy + 0.83 * radius * Math.sin(0 * Math.PI / 6f) + rect.height() / 2);
                            break;
                        case 2:
                            // 计算Baseline绘制的起点X轴坐标
                            baseX = (int) (cx - 0.83 * radius * Math.cos(11 * Math.PI / 6f) - rect.width() - 10);
                            // 计算Baseline绘制的Y坐标
                            baseY = (int) (cy + 0.83 * radius * Math.sin(11 * Math.PI / 6f) + rect.height() / 2-2);
                            break;
                        case 3:
                            // 计算Baseline绘制的起点X轴坐标
                            baseX = (int) (cx - 0.83 * radius * Math.cos(10 * Math.PI / 6f) - rect.width() - 10);
                            // 计算Baseline绘制的Y坐标
                            baseY = (int) (cy + 0.83 * radius * Math.sin(10 * Math.PI / 6f));
                            break;
                        case 4:
                            // 计算Baseline绘制的起点X轴坐标
                            baseX = (int) (cx - 0.82 * radius * Math.cos(9 * Math.PI / 6f) - rect.width() / 2 - 2);
                            // 计算Baseline绘制的Y坐标
                            baseY = (int) (cy + 0.82 * radius * Math.sin(9 * Math.PI / 6f) - 10);
                            break;
                        case 5:
                            // 计算Baseline绘制的起点X轴坐标
                            baseX = (int) (cx - 0.83 * radius * Math.cos(8 * Math.PI / 6f)+10);
                            // 计算Baseline绘制的Y坐标
                            baseY = (int) (cy + 0.83 * radius * Math.sin(8 * Math.PI / 6f));
                            break;
                        case 6:
                            // 计算Baseline绘制的起点X轴坐标
                            baseX = (int) (cx - 0.83 * radius * Math.cos(7 * Math.PI / 6f) + 10);
                            // 计算Baseline绘制的Y坐标
                            baseY = (int) (cy + 0.83 * radius * Math.sin(7 * Math.PI / 6f) + rect.height() / 2-2);
                            break;
                        case 7:
                            // 计算Baseline绘制的起点X轴坐标
                            baseX = (int) (cx - 0.83 * radius * Math.cos(6 * Math.PI / 6f) + 10);
                            // 计算Baseline绘制的Y坐标
                            baseY = (int) (cy + 0.83 * radius * Math.sin(6 * Math.PI / 6f) + rect.height() / 2);
                            break;
                        case 8:
                            // 计算Baseline绘制的起点X轴坐标
                            baseX = (int) (cx - 0.83 * radius * Math.cos(5 * Math.PI / 6f) + 10);
                            // 计算Baseline绘制的Y坐标
                            baseY = (int) (cy + 0.83 * radius * Math.sin(5 * Math.PI / 6f) + rect.height() / 2);
                            break;

                    }
                    canvas.drawText(text, baseX, baseY, drawScaleTestPaint);
                }
            }

        }

    }
    /**
     * 重置数据位
     */
    public void reset(){
        setTestValue(firstLabel);
        invalidate();
    }

}
