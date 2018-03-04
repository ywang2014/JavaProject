package com.poi;

import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hpsf.Util;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;

public class ExportExcel {
	
	public static void main(String[] args) {
		ExportExcel obj = new ExportExcel();
		obj.export();
	}

	public HSSFWorkbook export() {
		HSSFWorkbook workbook = new HSSFWorkbook();// ����һ��Excel�ļ�   
	    HSSFSheet sheet = workbook.createSheet();// ����һ��Excel��Sheet   
	    
	    sheet.createFreezePane(1, 3);// ����   
	    
	    // �����п�   
	    sheet.setColumnWidth(0, 1000);   
	    sheet.setColumnWidth(1, 3500);   
	    sheet.setColumnWidth(2, 3500);   
	    sheet.setColumnWidth(3, 6500);   
	    sheet.setColumnWidth(4, 6500);   
	    sheet.setColumnWidth(5, 6500);   
	    sheet.setColumnWidth(6, 6500);   
	    sheet.setColumnWidth(7, 2500);   
	    
	    // Sheet��ʽ   
	    HSSFCellStyle sheetStyle = workbook.createCellStyle();   
	    // ����ɫ���趨   
	    sheetStyle.setFillBackgroundColor(HSSFColor.GREY_25_PERCENT.index);   
	    // ǰ��ɫ���趨   
	    sheetStyle.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);   
	    // ���ģʽ   
	    sheetStyle.setFillPattern(HSSFCellStyle.FINE_DOTS);   
	    // �����е���ʽ   
	    for (int i = 0; i <= 14; i++) {   
	    	sheet.setDefaultColumnStyle((short) i, sheetStyle);   
	    }  
	    
	    // ��������   
	    HSSFFont headfont = workbook.createFont();   
	    headfont.setFontName("����");   
	    headfont.setFontHeightInPoints((short) 22);// �����С   
	    headfont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// �Ӵ�   
	   
	    // ��һ����ʽ   
	    HSSFCellStyle headstyle = workbook.createCellStyle();   
	    headstyle.setFont(headfont);   
	    headstyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// ���Ҿ���   
	    headstyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// ���¾���   
	    headstyle.setLocked(true);   
	    headstyle.setWrapText(true);// �Զ�����   
	   
	    // ��һ��������ʽ   
	    HSSFFont columnHeadFont = workbook.createFont();   
	    columnHeadFont.setFontName("����");   
	    columnHeadFont.setFontHeightInPoints((short) 10);   
	    columnHeadFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);   
	    
	    // ��ͷ����ʽ   
	    HSSFCellStyle columnHeadStyle = workbook.createCellStyle();   
	    columnHeadStyle.setFont(columnHeadFont);   
	    columnHeadStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// ���Ҿ���   
	    columnHeadStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// ���¾���   
	    columnHeadStyle.setLocked(true);   
	    columnHeadStyle.setWrapText(true);   
	    columnHeadStyle.setLeftBorderColor(HSSFColor.BLACK.index);// ��߿����ɫ   
	    columnHeadStyle.setBorderLeft((short) 1);// �߿�Ĵ�С   
	    columnHeadStyle.setRightBorderColor(HSSFColor.BLACK.index);// �ұ߿����ɫ   
	    columnHeadStyle.setBorderRight((short) 1);// �߿�Ĵ�С   
	    columnHeadStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); // ���õ�Ԫ��ı߿�Ϊ����   
	    columnHeadStyle.setBottomBorderColor(HSSFColor.BLACK.index); // ���õ�Ԫ��ı߿���ɫ   
	    // ���õ�Ԫ��ı�����ɫ����Ԫ�����ʽ�Ḳ���л��е���ʽ��   
	    columnHeadStyle.setFillForegroundColor(HSSFColor.WHITE.index);   
	  
	    HSSFFont font = workbook.createFont();   
	    font.setFontName("����");   
	    font.setFontHeightInPoints((short) 10);   
	    
	    // ��ͨ��Ԫ����ʽ   
	    HSSFCellStyle style = workbook.createCellStyle();   
	    style.setFont(font);   
	    style.setAlignment(HSSFCellStyle.ALIGN_LEFT);// ���Ҿ���   
	    style.setVerticalAlignment(HSSFCellStyle.VERTICAL_TOP);// ���¾���   
	    style.setWrapText(true);   
	    style.setLeftBorderColor(HSSFColor.BLACK.index);   
	    style.setBorderLeft((short) 1);   
	    style.setRightBorderColor(HSSFColor.BLACK.index);   
	    style.setBorderRight((short) 1);   
	    style.setBorderBottom(HSSFCellStyle.BORDER_THIN); // ���õ�Ԫ��ı߿�Ϊ����   
	    style.setBottomBorderColor(HSSFColor.BLACK.index); // ���õ�Ԫ��ı߿���ɫ��   
	    style.setFillForegroundColor(HSSFColor.WHITE.index);// ���õ�Ԫ��ı�����ɫ��   
	    
	    // ��һ����ʽ   
	    HSSFCellStyle centerstyle = workbook.createCellStyle();   
	    centerstyle.setFont(font);   
	    centerstyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// ���Ҿ���   
	    centerstyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// ���¾���   
	    centerstyle.setWrapText(true);   
	    centerstyle.setLeftBorderColor(HSSFColor.BLACK.index);   
	    centerstyle.setBorderLeft((short) 1);   
	    centerstyle.setRightBorderColor(HSSFColor.BLACK.index);   
	    centerstyle.setBorderRight((short) 1);   
	    centerstyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); // ���õ�Ԫ��ı߿�Ϊ����   
	    centerstyle.setBottomBorderColor(HSSFColor.BLACK.index); // ���õ�Ԫ��ı߿���ɫ��   
	    centerstyle.setFillForegroundColor(HSSFColor.WHITE.index);// ���õ�Ԫ��ı�����ɫ��   
	  
	    try {   
	    	// ������һ��   
	    	HSSFRow row0 = sheet.createRow(0);   
	    	// �����и�
	    	row0.setHeight((short) 900);   
	    	// ������һ��   
	    	HSSFCell cell0 = row0.createCell(0);   
	    	cell0.setCellValue(new HSSFRichTextString("��һ��ֵ"));   
	    	cell0.setCellStyle(headstyle);   
	    	
	    	/**  
	    	 * �ϲ���Ԫ��  
	    	 * ��һ����������һ����Ԫ�����������0��ʼ�� 
	    	 * �ڶ����������ڶ�����Ԫ�����������0��ʼ��  
	    	 * ��������������һ����Ԫ�����������0��ʼ��  
	    	 * ���ĸ��������ڶ�����Ԫ�����������0��ʼ��  
	    	 */ 
	    	CellRangeAddress range = new CellRangeAddress(0, 0, 0, 7);   
	    	sheet.addMergedRegion(range);   
	    	
	    	// �����ڶ��� 
	    	HSSFRow row1 = sheet.createRow(1);   
	    	HSSFCell cell1 = row1.createCell(0);   
	    	cell1.setCellValue(new HSSFRichTextString("���λ���ʱ�䣺2009��8��31��       ǰ�λ���ʱ�䣺2009��8��24��"));  
	    	cell1.setCellStyle(centerstyle);  
	    	// �ϲ���Ԫ�� 
	    	range = new CellRangeAddress(1, 2, 0, 7);   
	    	sheet.addMergedRegion(range);   
		      
	    	// ������   
		    HSSFRow row2 = sheet.createRow(3);  
		    row2.setHeight((short) 750);   
		    HSSFCell cell = row2.createCell(0);   
		    cell.setCellValue(new HSSFRichTextString("������"));   
		    cell.setCellStyle(columnHeadStyle);  
		    cell = row2.createCell(1);   
		    cell.setCellValue(new HSSFRichTextString("���������"));   
		    cell.setCellStyle(columnHeadStyle);   
		    cell = row2.createCell(2);   
		    cell.setCellValue(new HSSFRichTextString("����"));   
		    cell.setCellStyle(columnHeadStyle); 
		    cell = row2.createCell(3);   
		    cell.setCellValue(new HSSFRichTextString("ǰ�λ���Ҫ��/n/����Ŀ����Ŀ��Ҫ")); 
		    cell.setCellStyle(columnHeadStyle);  
		    cell = row2.createCell(4);  
		    cell.setCellValue(new HSSFRichTextString("���ܹ�����չ"));   
		    cell.setCellStyle(columnHeadStyle);   
		    cell = row2.createCell(5);   
		    cell.setCellValue(new HSSFRichTextString("���ܹ����ƻ�"));
		    cell.setCellStyle(columnHeadStyle);   
		    cell = row2.createCell(6);   
		    cell.setCellValue(new HSSFRichTextString("����ͽ���"));  
		    cell.setCellStyle(columnHeadStyle);   
		    cell = row2.createCell(7);   
		    cell.setCellValue(new HSSFRichTextString("�� ע"));   
		    cell.setCellStyle(columnHeadStyle);  
		    
		    // �������ݿ⣬�õ����ݼ�   
		    List<Object> deitelVOList = Arrays.asList("test1", "test2", "test3");   // getEntityManager().queryDeitelVOList();   
		    int rowNumber = 4;   
		    int k = 4;
		    for (int i = 0; i < deitelVOList.size(); i++) { 
		    	AssistObject vo = (AssistObject)deitelVOList.get(i);   
		    	String dname = vo.getName();   
		        List<WorkInfo> workList = vo.getWorkInfoList();   
		        HSSFRow row = sheet.createRow(rowNumber);   
		        cell = row.createCell(0);   
		        cell.setCellValue(new HSSFRichTextString(dname));   
		        cell.setCellStyle(centerstyle);   
		        // �ϲ���Ԫ��   
		        range = new CellRangeAddress(rowNumber, rowNumber + workList.size() - 1, 0, 0);   
		        sheet.addMergedRegion(range);   
		        rowNumber = rowNumber + workList.size();   
		        
		        for (int j = 0; j < workList.size(); j++) {   
		        	WorkInfo w = workList.get(j);   
		        	// �������ݼ�����Excel����   
		        	row = sheet.getRow(k + j);   
		        	if (null == row) {   
		        		row = sheet.createRow(k + j);   
		        	}   
		        	cell = row.createCell(1);   
		        	cell.setCellValue(w.getNumber());   
		        	cell.setCellStyle(centerstyle);   
		        	cell = row.createCell(2);   
		        	cell.setCellValue(new HSSFRichTextString(w.getItem()));   
		        	cell.setCellStyle(style);   
		        	cell = row.createCell(3);   
		        	cell.setCellValue(new HSSFRichTextString(w.getMeting()));  
		        	cell.setCellStyle(style);   
		        	cell = row.createCell(4);   
		        	cell.setCellValue(new HSSFRichTextString(w.getBweek()));   
		        	cell.setCellStyle(style);   
		        	cell = row.createCell(5);   
		        	cell.setCellValue(new HSSFRichTextString(w.getTweek()));   
		        	cell.setCellStyle(style);   
		        	cell = row.createCell(6);  
		        	cell.setCellValue(new HSSFRichTextString(w.getProblem()));   
		        	cell.setCellStyle(style);  
		        	cell = row.createCell(7);   
		        	cell.setCellValue(new HSSFRichTextString(w.getRemark()));   
		        	cell.setCellStyle(style);   
		        }   
		        k = k + workList.size();   
	        } 
		    
		    // ��β   
		    int footRownumber = sheet.getLastRowNum();  
		    HSSFRow footRow = sheet.createRow(footRownumber + 1);   
		    HSSFCell footRowcell = footRow.createCell(0);   
		    footRowcell.setCellValue(new HSSFRichTextString("                    ��  ����XXX      ��  �ˣ�XXX     ��  �ܣ�XX"));   
		    footRowcell.setCellStyle(centerstyle);   
		    range = new CellRangeAddress(footRownumber + 1, footRownumber + 1, 0, 7);   
		    sheet.addMergedRegion(range);  
		    return workbook;
	    } catch (Exception e) {   
	    	e.printStackTrace();
	    	return null;
	    } 
    }  
	
	public void buildExcelDocument(HSSFWorkbook workbook, HttpServletResponse response, HttpServletRequest request) {
		try {
			String filename = "δ����.xls";//��������ʱ�ͻ���Excel������   
			// �����http://zmx.javaeye.com/blog/622529   
			filename = new String(filename.getBytes("gb2312"), "iso8859-1");// Util.encodeFilename(filename, request)
			response.setContentType("application/vnd.ms-excel");   
			response.setHeader("Content-disposition", "attachment;filename=" + filename);  
			OutputStream ouputStream = response.getOutputStream(); 
			workbook.write(ouputStream);   
			ouputStream.flush();   
			ouputStream.close();   
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
