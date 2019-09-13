package us.supercheng.algorithm.problems.shoppingoffers;

import java.util.List;

class Solution {

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int ret = 0,
            len = price.size();

        for (int i=0;i<len;i++)
            ret += price.get(i) * needs.get(i);

        return this.seekBestOffer(price, special, needs, ret, 0, needs.size());
    }

    private int seekBestOffer(List<Integer> price, List<List<Integer>> offers, List<Integer> needs, int MAX_PRICE, int currPrice, int len) {
        if (!this.isValidNeeds(needs))
            return -1;

        int ret = MAX_PRICE;
        for (List<Integer> offer : offers) {
            for (int i=0;i<len;i++)
                needs.set(i, needs.get(i)-offer.get(i));

            int tempCurrent = offer.get(len) + currPrice;
            if (this.isEmptyNeeds(needs))
                ret = Math.min(tempCurrent, ret);
            else if (this.isValidNeeds(needs)) {
                int resA = notUsingOffer(price, needs, price.size()) + tempCurrent,
                        resB = this.seekBestOffer(price, offers, needs, MAX_PRICE, tempCurrent, len);
                if (resB != -1)
                    ret = Math.min(ret, Math.min(resB, resA));
                else
                    ret = Math.min(ret, resA);
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

    private boolean isValidNeeds(List<Integer> needs) {
        for (int need : needs)
            if (need < 0)
                return false;
        return true;
    }

    private int notUsingOffer(List<Integer> price, List<Integer> needs, int len) {
        int ret = 0;
        for (int i=0;i<len;i++) {
            int need = needs.get(i);
            if (need > 0)
                ret += need * price.get(i);
        }
        return ret;
    }
}