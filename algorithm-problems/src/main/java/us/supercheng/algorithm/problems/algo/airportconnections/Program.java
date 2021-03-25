package us.supercheng.algorithm.problems.algo.airportconnections;

import java.util.*;

public class Program {

    public static void main(String[] args) {
        List<String> airports = Arrays.asList(new String[]{"BGI", "CDG", "DEL", "DOH", "DSM", "EWR", "EYW", "HND", "ICN", "JFK", "LGA", "LHR", "ORD", "SAN", "SFO", "SIN", "TLV", "BUD"});
        List<List<String>> routes = new ArrayList<>();
        routes.add(Arrays.asList(new String[]{"DSM", "ORD"}));
        routes.add(Arrays.asList(new String[]{"ORD", "BGI"}));
        routes.add(Arrays.asList(new String[]{"BGI", "LGA"}));
        routes.add(Arrays.asList(new String[]{"SIN", "CDG"}));
        routes.add(Arrays.asList(new String[]{"CDG", "SIN"}));

        routes.add(Arrays.asList(new String[]{"CDG", "BUD"}));
        routes.add(Arrays.asList(new String[]{"DEL", "DOH"}));
        routes.add(Arrays.asList(new String[]{"DEL", "CDG"}));
        routes.add(Arrays.asList(new String[]{"TLV", "DEL"}));
        routes.add(Arrays.asList(new String[]{"EWR", "HND"}));

        routes.add(Arrays.asList(new String[]{"HND", "ICN"}));
        routes.add(Arrays.asList(new String[]{"HND", "JFK"}));
        routes.add(Arrays.asList(new String[]{"ICN", "JFK"}));
        routes.add(Arrays.asList(new String[]{"JFK", "LGA"}));
        routes.add(Arrays.asList(new String[]{"EYW", "LHR"}));

        routes.add(Arrays.asList(new String[]{"LHR", "SFO"}));
        routes.add(Arrays.asList(new String[]{"SFO", "SAN"}));
        routes.add(Arrays.asList(new String[]{"SFO", "DSM"}));
        routes.add(Arrays.asList(new String[]{"SAN", "EYW"}));

        airportConnections(airports, routes, "LGA");
    }

    public static int airportConnections(List<String> airports, List<List<String>> routes, String startingAirport) {
        Map<String, AirPort> g = buildGraph(airports, routes);
        markReachableDFS(g, startingAirport);
        addUnreachable(g, airports);
        return buildRet(g);
    }

    private static Map<String, AirPort> buildGraph(List<String> airports, List<List<String>> routes) {
        Map<String, AirPort> ret = new HashMap<>();

        for (String a : airports)
            ret.put(a, new AirPort(a));

        for (List<String> r : routes)
            ret.get(r.get(0)).connections.add(r.get(1));   // get from and add to

        return ret;
    }

    private static void markReachableDFS(Map<String, AirPort> g, String from) {
        AirPort airPort = g.get(from);
        if (airPort.isReachable)
            return;

        airPort.isReachable = true;

        for (String next : airPort.connections)
            markReachableDFS(g, next);
    }

    private static void addUnreachable(Map<String, AirPort> g, List<String> airports) {
        for (String a : airports)
            addUnreachableDFS(g, g.get(a), a);
    }

    private static void addUnreachableDFS(Map<String, AirPort> g, AirPort start, String from) {
        if (start.unreachableConnections.contains(from))
            return;

        if (!start.name.equals(from))
            start.unreachableConnections.add(from);

        for (String next : g.get(from).connections)
            if (!g.get(next).isReachable)
                addUnreachableDFS(g, start, next);
    }

    private static int buildRet(Map<String, AirPort> g) {
        int ret = 0;
        List<AirPort> airPortList = new ArrayList<>(g.values());
        Collections.sort(airPortList, new Comparator<AirPort>() {
            @Override
            public int compare(AirPort a1, AirPort a2) {
                return a2.unreachableConnections.size() - a1.unreachableConnections.size(); // desc by unreachable
            }
        });

        for (AirPort a : airPortList)
            if (!a.isReachable) {
                markReachableDFS(g, a.name);
                ret++;
            }

        return ret;
    }

    private static void debugGraph(Map<String, AirPort> g) {
        for (AirPort a : g.values())
            System.out.println(a);
    }

    static class AirPort {
        String name;
        Set<String> connections;
        Set<String> unreachableConnections;
        boolean isReachable;

        public AirPort(String name) {
            this.name = name;
            this.connections = new HashSet<>();
            this.unreachableConnections = new HashSet<>();
            this.isReachable = false;
        }

        public String toString() {
            return this.name + "|" + this.connections + "|" + this.isReachable + "|" + this.unreachableConnections;
        }
    }
}


