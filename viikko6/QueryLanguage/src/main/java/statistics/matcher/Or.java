package statistics.matcher;

import statistics.Player;

public class Or implements Matcher {

    private Matcher[] matchers;

    public Or(Matcher... matchers) {
        this.matchers = matchers;
    }

    @Override
    public boolean matches(Player p) {
      //System.out.println("matchereitä on " + matchers.length);
        for (Matcher matcher : matchers) {
            if (matcher.matches(p)) {
                //System.out.println("Toimii or:n matcherissa: " + p);
                return true;
            }
        }

        return false;
    }
}
