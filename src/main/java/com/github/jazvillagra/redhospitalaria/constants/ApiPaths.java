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
    /**
     * Camas URLs
     */
    public static final String BASE_CAMAS = BASE + "/camas";
    public static final String REGISTRAR_SERVICIO_HOSPITAL = BASE_HOSPITAL + "/registrar-servicio";
    public static final String CAMAS_DISPONIBLES_BY_HOSPITAL = BASE_CAMAS + "/hospital/{codHospital}";
    public static final String CAMAS_DISPONIBLES_BY_ID_SERVICIO = BASE_CAMAS + "/servicio/{idServicio}";
    /**
     * Paciente URLs
     */
    public static final String BASE_PACIENTE = BASE + "/paciente";
    public static final String BASE_PACIENTE_BY_NOMBRE_APELLIDO = BASE_PACIENTE + "/nombre/apellido";
    public static final String BASE_PACIENTE_BY_COD_HISTORIAL = BASE_PACIENTE + "/historial/{codHistorial}";
    public static final String PACIENTE_SAVE = BASE_PACIENTE + "/save";
    /**
     * Consulta URLs
     */
    public static final String BASE_CONSULTA = BASE + "/consulta";
    public static final String SAVE_CONSULTA = BASE_CONSULTA + "/save";
    public static final String CONSULTA_BY_ID = BASE_CONSULTA + "/{idConsulta}";
}
