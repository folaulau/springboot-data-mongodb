package com.lovemesomecoding.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

/**
 * Random Generator Utility is designed to use accross this API - It randomly
 * generate String, Number, and AlphaNumeric
 * 
 * @author fkaveinga
 * @see RandomStringUtils
 * @see RandomUtils
 */
public final class RandomGeneratorUtils {

	private static List<String> specialCharacters = Arrays.asList("@", "#", "$", "%", "!", "^", "&", "*", "()", "\"",
			"_", ",", "~", "`", "-", "=", "[", "]", "{", "}", "|", ";", ":", "'", ",", ".", "/", "<", ">", "?");

	// 30 length
	private static final int UUID_LENGTH = 30;
	
	private static String getUuid(StringBuilder uuid) {
		return uuid.append(RandomStringUtils.randomAlphanumeric(UUID_LENGTH)).toString();
	}
	
	
	public static String getString(int length) {
		return RandomStringUtils.randomAlphabetic(length);
	}

	public static int getInteger() {
		return RandomUtils.nextInt();
	}

	public static int getIntegerWithin(int start, int end) {
		return RandomUtils.nextInt(start, end);
	}

	public static Float getFloat() {
		return RandomUtils.nextFloat();
	}

	public static Float getIntegerWithin(float start, float end) {
		return RandomUtils.nextFloat(start, end);
	}

	public static Double getDouble() {
		return RandomUtils.nextDouble();
	}

	public static Double getDoubleWithin(double start, double end) {
		return RandomUtils.nextDouble(start, end);
	}

	public static String getAlphaNumeric(int length) {
		return RandomStringUtils.randomAlphanumeric(length);
	}

	public static String getSecret(int length, int numOfSpecialCharacters) {
		StringBuilder secret = new StringBuilder(RandomStringUtils.randomAlphanumeric(length - numOfSpecialCharacters));

		if (numOfSpecialCharacters > 0) {
			int size = specialCharacters.size();

			for (int i = 0; i < numOfSpecialCharacters; i++) {
				secret.append(specialCharacters.get(getIntegerWithin(0, size - 1)));
			}

		}
		return secret.toString();
	}

	// // 20 characters 4 pieces to ensure uniqueness
	// public static String getUuid() {
	// StringBuilder uuid = new StringBuilder();
	// for (int i = 0; i < 4; i++) {
	// uuid.append(RandomStringUtils.randomAlphabetic(5));
	// }
	// return uuid.toString();
	// }

	public static String getXApiKey() {
		StringBuilder uuid = new StringBuilder("xapi_");
		for (int i = 0; i < 5; i++) {
			uuid.append(RandomStringUtils.randomAlphabetic(5));
		}
		return uuid.toString();
	}

	// cff = care faciliy fee
	public static String getFacilityFeeUuid() {
		return getUuid(new StringBuilder("cff_"));
	}

	// dsp = doctor service price
	public static String getDoctorServicePriceUuid() {
		return getUuid(new StringBuilder("dsp_"));
	}

	public static String getCareUuid() {
		return getUuid(new StringBuilder("care_"));
	}

	// inap = insurance application
	public static String getInsuranceApplicationUuid() {
		return getUuid(new StringBuilder("inap_"));
	}

	// mmp = member medical prescription
	public static String getMemberMedicalPrescriptionUuid() {
		return getUuid(new StringBuilder("mmp_"));
	}

	// mmdp = member medical deny procedure
	public static String getMemberMedicalDenyProcedureUuid() {
		return getUuid(new StringBuilder("mmdp_"));
	}

	// ccr = coverage change reason
	public static String getCoverageChangeUuid() {
		return getUuid(new StringBuilder("ccr_"));
	}

	// mmha = member medical health answer
	public static String getMemberMedicalHeathAnswerUuid() {
		return getUuid(new StringBuilder("mmha_"));
	}

	// crq = coverage rate quote id
	public static String getCoverageRateQuoteId() {
		return getUuid(new StringBuilder("crq_"));
	}

	public static String getPaymentMethodUuid() {
		return getUuid(new StringBuilder("pm_"));
	}
	
	public static String getCheckUuid() {
		return getUuid(new StringBuilder("chec_"));
	}

	public static String getMemberMedicalHistoryUuid() {
		return getUuid(new StringBuilder("mmh_"));
	}

	public static String getToken() {
		return getUuid(new StringBuilder("tok_"));
	}
	
	

	// 20 characters 4 pieces to ensure uniqueness
	public static String getAccountUuid() {
		return getUuid(new StringBuilder("acc_"));
	}

	// 12 characters 4 pieces to ensure uniqueness
	public static String getCoverageUuid() {
		return getUuid(new StringBuilder("cov_"));
	}

	// 12 characters 4 pieces to ensure uniqueness
	public static String getMemberUuid() {
		return getUuid(new StringBuilder("mem_"));
	}

	// 12 characters 4 pieces to ensure uniqueness
	public static String getExpenseUuid() {
		return getUuid(new StringBuilder("exp_"));
	}
	
	public static String getTransactionUuid() {
		return getUuid(new StringBuilder("tran_"));
	}
	
	/**
	 * Get sidecar subscription uuid<br>
	 * This has to be different from stripe subscription id
	 * @return
	 */
	public static String getSidecarSubUuid() {
		return getUuid(new StringBuilder("sidecar_sub_"));
	}

	// 12 characters 4 pieces to ensure uniqueness
	public static String getReceiptUuid() {
		return getUuid(new StringBuilder("rec_"));
	}

	public static boolean getBoolean() {
		return RandomUtils.nextBoolean();
	}

	public static List<Integer> getNumbersInRangeAndOffset(int start, int finish, int offset) {
		List<Integer> numbers = new ArrayList<>();
		for (int i = start; i < finish; i += offset) {
			numbers.add(i);
		}
		return numbers;
	}

	// unique uuid for a queue call.
	public static String getNtcUuid() {
		return getUuid(new StringBuilder("ntc_"));
	}
	
	public static String getSQSUuid() {
		return getUuid(new StringBuilder("sqs"));
	}
	
	public static String getNtcSettingsUuid() {
		return getUuid(new StringBuilder("settings_"));
	}

	public static String getExpenseProviderRefundUuid() {
		return getUuid(new StringBuilder("epr_"));
	}

	public static String getVideoRecordingUuid() {
		return getUuid(new StringBuilder("cvr_"));
	}
	

}
