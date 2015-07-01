package com.girish;

/**
 * Created by Girish on 24-02-2015.
 */
public enum HashType {
    MD5,SHA;



    @Override
    public String toString() {
     return  this.name();
    }
}
