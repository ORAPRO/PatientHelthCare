package com.job.healthcare;

import java.io.File;

import com.hc.util.PropertyReader;

public class FileUtil {
PropertyReader propertyReader;

  public static boolean createDirectory(String path){
	  boolean isDirectory = false;
	  File f = new File(path);
	  isDirectory = f.mkdir();
	  
	return isDirectory ;
	  
  }
  public static boolean moveFile(File sourceFile,File destinationPath){
	return sourceFile.renameTo(new File(destinationPath, sourceFile.getName()));
  }
  
  public static boolean moveFile1(File sDir,File dDir){
	  boolean isFilesMoved =false;
	  if(sDir.isDirectory()){
		  File[] listFiles = sDir.listFiles();
		  int sSourceFilesCount = listFiles.length;
		  int moveFilesCount = 0;
		  
		  for(File f1: listFiles){
			  boolean isFileMoved = moveFile(f1,dDir);
			  if(isFileMoved){
				  moveFilesCount++;
				  System.out.println("Successfully moved " + f1);
			  }else{
				  System.out.println("file Moved unsuccessfully " + f1);
			  }
		  }
		  if(sSourceFilesCount == moveFilesCount){
			  isFilesMoved = true;
			  System.out.println("All file moved Successfully.......");
		  }else if(moveFilesCount > 0 && moveFilesCount < sSourceFilesCount){
			  System.out.println("Files moved partially....");
		  }else{
			  System.out.println("Files are not moved");
		  }
	  }
	return isFilesMoved;
	  
  }

  public static boolean deleteDirectory(File f3){
	return f3.delete();
  }
  public boolean deleteDirectory1(File dir){
	  boolean isDirDeleted = false;
	  if(dir.isDirectory()){
		  if(dir.listFiles().length == 0){
			  if(!(dir.getAbsolutePath().equalsIgnoreCase(propertyReader.getHealthcarePropertyReader().getProperty(null)))){
				  isDirDeleted  = dir.delete();
				  System.out.println("Deleted : " +dir.getAbsolutePath());
				  deleteDirectory(dir.getAbsoluteFile());
				  
			  }
		  }
		  
	  }
	  
	return isDirDeleted;
	  
  }
//	public int moveLocalFiles(final String inputLoc, final String outputLoc)
//			throws IOException {
//		File destinationFolder = new File(outputLoc);
//		File sourceLoc = new File(inputLoc);
//
//		if (!destinationFolder.exists()) {
//			destinationFolder.mkdirs();
//		}
//
//		FileUtils.moveFileToDirectory(sourceLoc, destinationFolder, false);
//		return 0;
//	}
//
//	public String getArchiveLoc() {
//		return "/home/edureka/VIRWS/batch071116/SchemaEvolution/archive";
//	}
//	public String getFailedLoc()
//	{
//		return "/home/edureka/VIRWS/batch071116/SchemaEvolution/failed";
//	}

}
