package name.huangzhoujin.registration.utils;

import java.util.Date;
import java.util.List;

import name.huangzhoujin.registration.persistence.dto.CustomDto;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class ExcelUtil {
	
	public static String generateFileName(String prefix){
		Date now = new Date();
		String timestamp = DateUtil.dateToStrstamp(now);
		String result= prefix +"-"+timestamp+".xls";
		return result;
	}

	public static HSSFWorkbook generateExcel(List<CustomDto> customDtoList) {
		HSSFWorkbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet("Report");
		Row row = sheet.createRow(0);

		// Header
		Cell cell = row.createCell(0);
		cell.setCellValue("编号");

		cell = row.createCell(1);
		cell.setCellValue("姓名");

		cell = row.createCell(2);
		cell.setCellValue("性别");

		cell = row.createCell(3);
		cell.setCellValue("学历");

		cell = row.createCell(4);
		cell.setCellValue("培训专业");

		cell = row.createCell(5);
		cell.setCellValue("原等级");

		cell = row.createCell(6);
		cell.setCellValue("申报等级");

		cell = row.createCell(7);
		cell.setCellValue("身份证号");

		cell = row.createCell(8);
		cell.setCellValue("联系电话");

		cell = row.createCell(9);
		cell.setCellValue("工作单位");

		cell = row.createCell(10);
		cell.setCellValue("失业编号");

		cell = row.createCell(11);
		cell.setCellValue("开课时间");

		cell = row.createCell(12);
		cell.setCellValue("培训地址");

		cell = row.createCell(13);
		cell.setCellValue("报名时间");
		
		cell = row.createCell(14);
		cell.setCellValue("通信地址（身份证地址）");

		CreationHelper createHelper = wb.getCreationHelper();
		CellStyle cellStyle = wb.createCellStyle();
		cellStyle.setDataFormat(createHelper.createDataFormat().getFormat(
				SystemConstants.defaultFormat2));

		int length = customDtoList.size();
		CustomDto data = null;
		for (int i = 0; i < length; i++) {
			int no = i + 1;
			row = sheet.createRow(no);
			data = customDtoList.get(i);

			cell = row.createCell(0);
			cell.setCellValue(no);

			cell = row.createCell(1);
			cell.setCellValue(data.getRegister());

			cell = row.createCell(2);
			cell.setCellValue(data.getGender());

			cell = row.createCell(3);
			cell.setCellValue(data.getEducation() == null ? "" : data
					.getEducation());

			cell = row.createCell(4);
			cell.setCellValue(data.getAreaName());

			cell = row.createCell(5);
			cell.setCellValue(data.getOldLevel());

			cell = row.createCell(6);
			cell.setCellValue(data.getNewLevel());

			cell = row.createCell(7);
			cell.setCellValue(data.getIdCard());

			cell = row.createCell(8);
			cell.setCellValue(data.getPhone() == null ? "" : data.getPhone());

			cell = row.createCell(9);
			cell.setCellValue(data.getWorkUnit() == null ? "" : data
					.getWorkUnit());

			cell = row.createCell(10);
			cell.setCellValue(data.getUnemployedNo() == null ? "" : data
					.getUnemployedNo());

			cell = row.createCell(11);
			if (data.getStartDate() != null) {
				cell.setCellValue(data.getStartDate());
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(12);
			cell.setCellValue(data.getLocationName());

			cell = row.createCell(13);
			if (data.getRegistrationDate() != null) {
				cell.setCellValue(data.getRegistrationDate());
				cell.setCellStyle(cellStyle);
			}
			
			cell = row.createCell(14);
			cell.setCellValue(data.getPostAddress() == null ? "" : data.getPostAddress());
		}

		// ByteArrayOutputStream baos = new ByteArrayOutputStream();
		// try {
		// wb.write(baos);
		// } catch (IOException e) {
		// e.printStackTrace();
		// }

		// byte[] ba = baos.toByteArray();
		// ByteArrayInputStream bais = new ByteArrayInputStream(ba);
		// return bais;
		return wb;

	}

	public static void main(String[] args) {
//		List<CustomDto> customDtoList = new ArrayList<CustomDto>();
//		CustomDto c1 = new CustomDto();
//		c1.setAreaName("Huang");
//		c1.setEducation("名");
//		c1.setRegistrationDate(new Date());
//		c1.setStartDate(new Date(-1));
//
//		CustomDto c2 = new CustomDto();
//		c2.setGender("Hu");
//		c2.setRegistrationDate(new Date());
//		c2.setStartDate(new Date(-2));
//
//		CustomDto c3 = new CustomDto();
//		c3.setStartDate(new Date(-1));
//		c3.setPhone("123353");
//		c3.setRegistrationDate(new Date());
//		c3.setStartDate(new Date(-3));
//
//		customDtoList.add(c1);
//		customDtoList.add(c2);
//		customDtoList.add(c3);
//
//		generateExcel(customDtoList);
		
		System.out.println(generateFileName(SystemConstants.defaultExcelProfix));

	}

}
