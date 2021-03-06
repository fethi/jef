package com.norconex.jef.factories;

import java.io.File;

import com.norconex.jef.IJob;
import com.norconex.jef.SyncJobGroup;
import com.norconex.jef.suite.IJobSuiteFactory;
import com.norconex.jef.suite.JobSuite;
import com.norconex.jef.jobs.ListFilesJob;

public class SyncSuiteFactory implements IJobSuiteFactory {

    public SyncSuiteFactory() {
        super();
    }

    @Override
    public JobSuite createJobSuite() {
    	String path = getPath();
    	if (path == null) {
    		System.out.println("No valid path given.");
    		return null;
    	}
    	 // Assemble the synchronous jobs.
        IJob listAlljob =
              new ListFilesJob("listFile.root.recursive", path, true);
//                new ListFilesJob("listFile.root.recursive", "c:\\temp", true);
        IJob listRootFilesJob =
        		new ListFilesJob("listFile.root.nonrecursive", path, false);
//        new ListFilesJob("listFile.root.nonrecursive", "c:\\temp", false);
        IJob syncListGroup = new SyncJobGroup(
                "test.sync",
                new IJob[] {listAlljob, listRootFilesJob}
        );
        
        return new JobSuite(syncListGroup);
    }

	private String getPath() {
		if (System.getProperty("java.io.tmpdir") != null) {
			return System.getProperty("java.io.tmpdir");
		}
		String[] filePathStrings = new String[] {
    			"c:\\temp",
    			"c:\\Windows\\temp"
    	};
    	File f;
    	for (int i =0;i<filePathStrings.length;i++) {
    		f = new File(filePathStrings[i]);
    		if (f.exists()) {
    			return filePathStrings[i];
    		}
    	}
    	return null;
	}

}