package com.pentaon.vzon.data.barcode;

import com.pentaon.vzon.pojo.BarcodeInfo;
import com.pentaon.vzon.utils.AppConstants;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by jongHwan.Kim  on 25,7월,2018
 * 시리얼 번호- 진위 확인 유형 코드 :: "반품 오더 회수"
 */
public class VerifyingReturnOrderRetrieval implements BarcodeVerification {
    private long mParamId;
    private long mParamItemId;
    private long mProdId;

    public VerifyingReturnOrderRetrieval(JSONObject obj){
        try {
            mParamId = obj.getLong(AppConstants.PARAM_ID);
            mParamItemId = obj.getLong(AppConstants.PARAM_ITEM_ID);
            mProdId = obj.getLong(AppConstants.PROD_ID);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public BarcodeInfo pickBarcodeInfoOut(String barcode) {
        return new BarcodeInfo.Builder()
                .setParamId(mParamId)
                .setParamItemId(mParamItemId)
                .setProdId(mProdId)
                .setType(AppConstants.BARCODE_VERIFY_RETURN_ORDER_RETRIEVAL)
                .setSerialNumber(barcode)
                .build();
    }
}
