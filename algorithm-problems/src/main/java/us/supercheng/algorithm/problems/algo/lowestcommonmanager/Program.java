package us.supercheng.algorithm.problems.algo.lowestcommonmanager;

import java.util.*;

public class Program {

    public static OrgChart getLowestCommonManager(OrgChart topManager, OrgChart reportOne, OrgChart reportTwo) {
        return manageChain(topManager, reportOne, reportTwo).commonManager;
    }

    private static NodeInfo manageChain(OrgChart currManager, OrgChart one, OrgChart two) {
        NodeInfo ret = new NodeInfo();

        if (currManager == null)
            return ret;

        if (currManager == one || currManager == two)
            ret.count = 1;

        for (OrgChart each : currManager.directReports) {
            NodeInfo ans = manageChain(each, one, two);
            if (ans.count == 1) {
                ret.count += 1;
                if (ret.count == 2) {
                    ret.commonManager = currManager;
                    break;
                }
            } else if (ans.count == 2)
                return ans;
        }

        return ret;
    }

    static class NodeInfo {
        public int count;
        public OrgChart commonManager;
    }

    static class OrgChart {
        public char name;
        public List<OrgChart> directReports;

        OrgChart(char name) {
            this.name = name;
            this.directReports = new ArrayList<OrgChart>();
        }

        // This method is for testing only.
        public void addDirectReports(OrgChart[] directReports) {
            for (OrgChart directReport : directReports) {
                this.directReports.add(directReport);
            }
        }
    }
}

