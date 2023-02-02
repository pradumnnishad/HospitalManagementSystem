package com.ty.hospital.dao;

import java.util.List;

import com.ty.hospital.dto.Branch;

public interface BranchDao {
	public  Branch saveBranch( int hid,Branch branch);
	 public boolean deleteBranch(int bid);
	 public  Branch getBranchById(int bid);
	 public  Branch updateBranchById(int bid, Branch branch);
	 public List<Branch> getAllBranch();
}
