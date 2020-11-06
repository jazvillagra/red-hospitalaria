package com.github.jazvillagra.redhospitalaria.constants;

public class ApiPaths {

    public static final String API_PATTERN = "/api/.*";
    public static final String BASE = "/api";
    /**
     * Hospital URLs
     */
    public static final String BASE_HOSPITAL = BASE + "/hospital";
    public static final String HOSPITAL_SAVE = BASE_HOSPITAL + "/save";
    public static final String HOSPITAL_BY_COD_HOSPITAL = BASE_HOSPITAL + "/{codHospital}";
}
