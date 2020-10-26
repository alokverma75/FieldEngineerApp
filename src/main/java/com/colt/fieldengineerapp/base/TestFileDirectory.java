package com.colt.fieldengineerapp.base;

import java.io.File;
import java.io.IOException;

public class TestFileDirectory {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//String dirPath = "C:\\nonExistedDirectory\\directory";
				String dirPath = System.getProperty("user.dir");
		        String newDirName = "Recordings";
		        String newFileName = "file1.txt";
		        String anotherNewFileName = "file2.txt";
		 
		        File newDirectory = new File(dirPath);
		        //Create directory for non existed path.
		        boolean isCreated = newDirectory.mkdirs();
		        if (isCreated) {
		            System.out.printf("1. Successfully created directories, path:%s",
		                    newDirectory.getCanonicalPath());
		        } else if (newDirectory.exists()) {
		            System.out.printf("1. Directory path already exist, path:%s",
		                    newDirectory.getCanonicalPath());
		        } else {
		            System.out.println("1. Unable to create directory");
		            return;
		        }
		 
		        //Create file under new directory path C:\newDirectory\directory
		        File newFile = new File(dirPath + File.separator + newFileName);
		        //Create new file under specified directory
		        isCreated = newFile.createNewFile();
		        if (isCreated) {
		            System.out.printf("\n2. Successfully created new file, path:%s",
		                    newFile.getCanonicalPath());
		        } else { //File may already exist
		            System.out.printf("\n2. Unable to create new file");
		        }
		 
		        //Create new directory under C:\nonExistedDirectory\directory
		        File oneMoreDirectory = new File(dirPath + File.separator + newDirName);
		        //Create directory for existed path.
		        isCreated = oneMoreDirectory.mkdir();
		        if (isCreated) {
		            System.out.printf("\n3. Successfully created new directory, path:%s",
		                    oneMoreDirectory.getCanonicalPath());
		        } else { //Directory may already exist
		            System.out.printf("\n3. Unable to create directory");
		        }
		 
		        //Create file under new directory path C:\newDirectory\directory
		        File anotherNewFile = new File(oneMoreDirectory + File.separator + anotherNewFileName);
		 
		        //Create new file under specified directory
		        isCreated = anotherNewFile.createNewFile();
		        if (isCreated) {
		            System.out.printf("\n4. Successfully created new file, path:%s",
		                    anotherNewFile.getCanonicalPath());
		        } else { //File may already exist
		            System.out.printf("\n4. Unable to create new file");
		        }

	}

}
