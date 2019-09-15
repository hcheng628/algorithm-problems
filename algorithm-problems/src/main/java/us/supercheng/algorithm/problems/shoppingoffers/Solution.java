package us.supercheng.algorithm.problems.shoppingoffers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int ret = 0,
                len = price.size();

        for (int i=0;i<len;i++)
            ret += price.get(i) * needs.get(i);

        return this.seekBestOffer(price, special, needs, ret, 0, len);
    }

    private int seekBestOffer(List<Integer> price, List<List<Integer>> offers, List<Integer> needs, int MAX_PRICE, int currPrice, int len) {
        int ret = MAX_PRICE;
        for (List<Integer> offer : offers) {
            boolean useOffer = true;
            for (int i=0;i<len;i++) {
                int res = needs.get(i)-offer.get(i);
                needs.set(i, res);

                if (res < 0) {
                    for (;i>-1;i--)
                        needs.set(i, needs.get(i)+offer.get(i));
                    useOffer = false;
                    break;
                }
            }

            if (!useOffer)
                continue;

            int tempCurrent = offer.get(len) + currPrice;

            if (tempCurrent < MAX_PRICE) {
                if (this.isEmptyNeeds(needs))
                    ret = Math.min(tempCurrent, ret);
                else {
                    int resA = this.purchase(price, needs, len) + tempCurrent,
                            resB = this.seekBestOffer(price, offers, needs, MAX_PRICE, tempCurrent, len);
                    ret = Math.min(ret, Math.min(resB, resA));
                }
            }

            for (int i=0;i<len;i++)
                needs.set(i, needs.get(i)+offer.get(i));
        }

        return ret;
    }

    private boolean isEmptyNeeds(List<Integer> needs) {
        for (int need : needs)
            if (need != 0)
                return false;
        return true;
    }

    public int shoppingOffersMemo(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return this.goShopping(price, special, needs, needs.size(), new HashMap<>());
    }

    private int goShopping(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int needsLen, HashMap<List<Integer>, Integer> memo) {
        if (memo.containsKey(needs))
            return memo.get(needs);

        int ret = this.purchase(price, needs, needsLen);
        for (List<Integer> offer : special) {
            int len = offer.size();
            List<Integer> newNeeds = new ArrayList<>();

            for (int i=0;i<len-1;i++) {
                int res = needs.get(i) - offer.get(i);
                if (res < 0) {
                    newNeeds = null;
                    break;
                }
                newNeeds.add(res);
            }
            if (newNeeds != null)
                ret = Math.min(ret, this.shoppingOffers(price, special, newNeeds) + offer.get(len-1));
        }

        memo.put(needs, ret);
        return ret;
    }

    private int purchase(List<Integer> price, List<Integer> needs, int needsLen) {
        int ret = 0;
        for (int i=0;i<needsLen;i++) {
            int res = needs.get(i);
            if (res != 0)
                ret += res * price.get(i);
        }
        return ret;
    }
}