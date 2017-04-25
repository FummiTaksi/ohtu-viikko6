package statistics;

import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));



                          QueryBuilder query = new QueryBuilder();

                          //Matcher m = new Or(new PlaysIn("PHI"), new PlaysIn("EDM"));
                          Matcher m = query.oneOf(query.playsIn("PHI").build(), query.playsIn("EDM").build()).build();

                          //Matcher m = new Or(query.playsIn("PHI")
                               //.hasAtLeast(10, "goals")
                               //.build(),  query.playsIn("EDM")
                               //.hasAtLeast(50, "points").build());
                          //Matcher m = query.oneOf(
                          //query.playsIn("PHI")
                               //.hasAtLeast(10, "goals")
                               //.hasFewerThan(15, "assists").build(),

                               //query.playsIn("EDM")
                             //.hasAtLeast(50, "points").build());


                         for (Player player : stats.matches(m)) {
                           System.out.println( player );
                         }
                             }

}
