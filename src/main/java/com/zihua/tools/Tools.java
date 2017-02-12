package com.zihua.tools;

import com.google.gson.GsonBuilder;
import com.zihua.skipe.*;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by zihua on 17-2-5.
 */

public class Tools {


    public static String md5(String plainText) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            try {
                md.update(plainText.getBytes("UTF8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer(200);
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset] & 0xff;
                if (i < 16) buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            return buf.toString();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public static String encoding(String id) {
        return id + "@#$%!" + 66666;
    }

    public static Integer decoding(String t) {
        return Integer.valueOf(t.split("[@#$%!]+")[0]);

    }

    public static String getUserJson(Object user) {
        GsonBuilder gb = new GsonBuilder();
        gb.setExclusionStrategies(new SkipeUsers());
        gb.setExclusionStrategies(new SkipePassword());
        gb.setExclusionStrategies(new SkipePermits());
        return gb.create().toJson(user);
    }


    public static String getRoleJson(Object role) {
        GsonBuilder gb = new GsonBuilder();
        gb.setExclusionStrategies(new SkipeRoles());
        gb.setExclusionStrategies(new SkipeUsers());
        return gb.create().toJson(role);
    }

    public static String getPermitJson(Object permit) {
        GsonBuilder gb = new GsonBuilder();
        gb.setExclusionStrategies(new SkipeRoles());
        return gb.create().toJson(permit);
    }

    public static String getStudentJson(Object student) {
        GsonBuilder gb = new GsonBuilder();
        gb.setExclusionStrategies(new SkipeStudent());
        gb.setExclusionStrategies(new SkipeTeacher());
        return gb.create().toJson(student);
    }

    public static String getCourseJson(Object course) {
        GsonBuilder gb = new GsonBuilder();
        gb.setExclusionStrategies(new SkipeStudent());
        gb.setExclusionStrategies(new SkipeCourse());
        return gb.create().toJson(course);
    }

    public static String getTeacherJson(Object teacher) {
        GsonBuilder gb = new GsonBuilder();
        gb.setExclusionStrategies(new SkipeTeacher());
        gb.setExclusionStrategies(new SkipeStudent());
        return gb.create().toJson(teacher);
    }

    public static String delespace(String data){
        return data.replaceAll("[ ]+","");
    }


}
