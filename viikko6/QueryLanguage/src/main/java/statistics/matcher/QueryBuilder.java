package statistics.matcher;

import java.util.*;

public class QueryBuilder {
  private Matcher matcher;
  private ArrayList<Matcher> matchers;
  public QueryBuilder() {
    this.matchers = new ArrayList();
  }

  public QueryBuilder playsIn(String team) {
    matchers.add(new PlaysIn(team));
    return this;
  }

  public QueryBuilder hasAtLeast(int score, String category) {
    matchers.add(new HasAtLeast(score, category));
    return this;
  }

  public QueryBuilder hasFewerThan(int score, String category) {
    matchers.add(new HasFewerThan(score, category));
    return this;
  }

  public QueryBuilder oneOf(Matcher ... params) {
    matchers.add(new Or(params));
    return this;
  }

  public Matcher[] getMatchers(ArrayList<Matcher> matchers) {
    Matcher[] newMatchers = new Matcher[matchers.size()];
    newMatchers = matchers.toArray(newMatchers);
    return newMatchers;
  }

  public Matcher build() {
    return new Or(getMatchers(matchers));
  }
}
