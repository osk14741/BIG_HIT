package com.bighit.on.thread;

import java.util.List;

import com.bighit.on.cmn.Search;

public interface ThreadService {
   
   int doInsert(ThreadVO threadVO);
   
   int doInsertRep(ThreadVO threadVO);

   int doDelete(ThreadVO threadVO);
   
   public List<ThreadVO> doSelectAll(ThreadVO threadVO);
   
   int doUpdate(ThreadVO threadVO);
   
   public List<ThreadVO> doSelectList(Search search);
   
   ThreadVO doSelectOne(ThreadVO threadVO);
   
   public List<ThreadVO> doSelectChildList(ThreadVO threadVO);
}