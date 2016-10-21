package com.letzgro.viewpager2.model;

/**
 * Created by bomko on 18.10.16.
 */

public class Trip {

    private String mName;
    private String mCountryFrom;
    private String mCountryTo;
    private String mDateStart;
    private String mDateEnd;
    private String mStatus;

    private int mCountLoads;
    private int mCountStops;

    public Trip(String name, String countryFrom, String countryTo, String dateStart, String dateEnd, String status, int countLoads, int countStops) {
        mName = name;
        mCountryFrom = countryFrom;
        mCountryTo = countryTo;
        mDateStart = dateStart;
        mDateEnd = dateEnd;
        mStatus = status;
        mCountLoads = countLoads;
        mCountStops = countStops;
    }

    public String getCountryFrom() {
        return mCountryFrom;
    }

/*    public void setCountryFrom(String countryFrom) {
        mCountryFrom = countryFrom;
    }*/

    public String getCountryTo() {
        return mCountryTo;
    }

    /*  public void setCountryTo(String countryTo) {
          mCountryTo = countryTo;
      }
  */
    public String getDateStart() {
        return mDateStart;
    }

    /*  public void setDateStart(String dateStart) {
          mDateStart = dateStart;
      }
  */
    public String getDateEnd() {
        return mDateEnd;
    }
/*

    public void setDateEnd(String dateEnd) {
        mDateEnd = dateEnd;
    }
*/

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getCountLoads() {
        return mCountLoads;
    }

    /*  public void setCountLoads(int countLoads) {
          mCountLoads = countLoads;
      }

     */
    public int getCountStops() {
        return mCountStops;
    }

    /*   public void setCountStops(int countStops) {
           mCountStops = countStops;
       }
   */
    public String getStatus() {
        return mStatus;
    }

  /*  public void setStatus(String status) {
        mStatus = status;
    }
*/

}
