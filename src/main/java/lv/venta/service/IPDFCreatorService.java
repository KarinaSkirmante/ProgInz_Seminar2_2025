package lv.venta.service;

public interface IPDFCreatorService {
	void createCertificateAsPDF(int studId, int courseId) throws Exception;

}
