package wealthguard.service;

public interface IScoreFinancieroService {

    /**
     * Calcula el score financiero de un usuario específico. El score financiero
     * se basa en el análisis de los datos financieros del usuario, como sus
     * ingresos, gastos, presupuestos y objetivos financieros. El cálculo del
     * score financiero puede incluir factores como la estabilidad financiera,
     * la capacidad de ahorro, la diversificación de inversiones y el
     * cumplimiento de metas financieras.
     *
     * @param idUsuario ID del usuario para el cual se calculará el score
     * financiero
     * @return true si el cálculo del score financiero se realizó exitosamente,
     * false en caso contrario.
     */
    public boolean calcularScoreFinanciero(int idUsuario);

}
