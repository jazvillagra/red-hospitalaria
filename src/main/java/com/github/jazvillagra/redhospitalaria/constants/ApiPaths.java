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

    /**
     * Servicio URLs
     */
    public static final String BASE_SERVICIO = BASE + "/servicio";
    public static final String SERVICIO_SAVE = BASE_SERVICIO + "/save";
    public static final String SERVICIO_BY_COD_SERVICIO = BASE_SERVICIO + "/{codServicio}";
    /**
     * Medico URLs
     */
    public static final String BASE_MEDICO = BASE + "/medico";
    public static final String MEDICO_SAVE = BASE_MEDICO + "/save";
    public static final String MEDICO_BY_NRO_DOCUMENTO = BASE_MEDICO + "/{nroDocumento}";
    public static final String MEDICO_BY_NOMBRE_APELLIDO = BASE_MEDICO + "/nombre-medico";
    /**
     * Servicio Prestado URLs
     */
    public static final String BASE_SERVICIO_PRESTADO = BASE + "/servicio-prestado";
    public static final String SERVICIO_PRESTADO_BY_ID_HOSPITAL = BASE_SERVICIO_PRESTADO + "/{idHospital}";
    public static final String SERVICIO_PRESTADO_BY_ID_SERVICIO = SERVICIO_PRESTADO_BY_ID_HOSPITAL + "/{idServicio}";
    public static final String SERVICIO_PRESTADO_BY_ID_MEDICO = SERVICIO_PRESTADO_BY_ID_SERVICIO + "/{idMedico}";
}
