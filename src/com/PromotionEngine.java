package com.main;

import java.util.List;

/**
 * @author Shwetha 
 * This is util class having method to calculate total price by
 *         applying discounts
 */
public class PromotionEngine {

	/**
	 * @returns int totalPriceOfAll
	 * @input Products List of products having details of number of Occurances of A,
	 *        B, C,D 
	 * This method calculate total price by applying discounts
	 * 
	 */
	public int getTotalPrice(List<Product> products) {
		int counterOfA = 0;
		int counterOfB = 0;
		int counterOfC = 0;
		int counterOfD = 0;
		for (Product product : products) {
			switch (product.getId().toUpperCase()) {
			case PromotionConsts.AId:
				counterOfA = product.getOccuranceOfIdInCart();
				break;
			case PromotionConsts.BId:
				counterOfB = product.getOccuranceOfIdInCart();
				break;
			case PromotionConsts.CId:
				counterOfC = product.getOccuranceOfIdInCart();
				break;
			case PromotionConsts.DId:
				counterOfD = product.getOccuranceOfIdInCart();
				break;
			}
		}
		// applying discount on multiple of 3 As and for the rest of As applying normal
		// price
		int totalPriceOfA = (counterOfA / PromotionConsts.numberOfAsdiscountAplicableOn)
				* PromotionConsts.discountRateOnAs
				+ (counterOfA % PromotionConsts.numberOfAsdiscountAplicableOn * PromotionConsts.priceOfA);
		// applying discount on multiple of 2Bs and for the rest of Bs applying normal
		// price
		int totalPriceOfB = (counterOfB / PromotionConsts.numberOfBsdiscountAplicableOn)
				* PromotionConsts.discountRateOnBs
				+ (counterOfB % PromotionConsts.numberOfBsdiscountAplicableOn * PromotionConsts.priceOfB);

		int totalPriceOfCandD = 0;
		int cAndDDifference = 0;
		int totalCountOfCandD = counterOfC + counterOfD;
		/*
		 * If count of C is greater than count of D , then applying discount on Combo of
		 * C and D and for the rest of Cs applying normal price
		 */
		if (counterOfC > counterOfD) {
			cAndDDifference = counterOfC - counterOfD;
			totalCountOfCandD -= cAndDDifference;
			totalPriceOfCandD = (totalCountOfCandD / PromotionConsts.numberOfCandDdiscountAplicableOn)
					* PromotionConsts.discountOnComboCandD + cAndDDifference * PromotionConsts.priceOfC;
		}
		/*
		 * If count of D is greater than count of C , then applying discount on Combo of
		 * C and D and for the rest of Ds applying normal price
		 */
		else if (counterOfC < counterOfD) {
			cAndDDifference = counterOfD - counterOfC;
			totalCountOfCandD -= cAndDDifference;
			totalPriceOfCandD = (totalCountOfCandD / PromotionConsts.numberOfCandDdiscountAplicableOn)
					* PromotionConsts.discountOnComboCandD + cAndDDifference * PromotionConsts.priceOfD;
		}
		/*
		 * If count of D is equal to C , then applying discount on Combo of C and D
		 */
		else
			totalPriceOfCandD = (totalCountOfCandD / PromotionConsts.numberOfCandDdiscountAplicableOn)
					* PromotionConsts.discountOnComboCandD;

		// returning the sum of all
		return totalPriceOfA + totalPriceOfB + totalPriceOfCandD;

	}
}
