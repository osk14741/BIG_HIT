package com.bighit.on.file;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

	@Autowired
	FileDaoImpl fileDao;
	
	public int doInsert(FileVO fileVO) {
		return fileDao.doInsert(fileVO);
	}
	
	public int doDelete(FileVO fileVO) {
		return fileDao.doDelete(fileVO);
	}
	
	public int doUpdate(FileVO fileVO) {
		return fileDao.doUpdate(fileVO);
	}
	
	public FileVO doSelectOne(FileVO fileVO) {
		return (FileVO) fileDao.doSelectOne(fileVO);
	}
	
	public List<FileVO> doSelectListChLink(FileVO fileVO){
		return fileDao.doSelectListChLink(fileVO);
	}
	
	public List<FileVO> doSelectListThrKey(FileVO fileVO){
		return fileDao.doSelectListThrKey(fileVO);
	}
	
	/**
	 * 
	 * @param filePath (file URL)
	 * @param upPath (S3 URL(key_name))
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	public int doFileUpload(String filePath, String upPath, MultipartFile multiFile) throws IllegalStateException, IOException {
		
		return fileDao.doFileUpload(filePath, upPath, multiFile);
	}
	
}
