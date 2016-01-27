package com.onlinejudge.domain;

/**
 * @author 赵笑天
 *
 * @time 2015年9月22日
 * 
 */
public class SubmitPageProblemInfo {
		private int problemid;
		private String problemtitle;
		private String problemcontent;
		
		public SubmitPageProblemInfo(int problemid,String problemtitle){
			
		}
		
		public SubmitPageProblemInfo(Integer problemid, String problemtitle,
				String problemcontent) {
			this.problemid = problemid;
			this.problemtitle = problemtitle;
			this.problemcontent = problemcontent;
		}

		public int getProblemid() {
			return problemid;
		}
		public void setProblemid(int problemid) {
			this.problemid = problemid;
		}

		public String getProblemtitle() {
			return problemtitle;
		}

		public void setProblemtitle(String problemtitle) {
			this.problemtitle = problemtitle;
		}

		@Override
		public String toString() {
			return "SubmitPageProblemInfo [problemid=" + problemid
					+ ", problemtitle=" + problemtitle + "]";
		}

		public String getProblemcontent() {
			return problemcontent;
		}

		public void setProblemcontent(String problemcontent) {
			this.problemcontent = problemcontent;
		}

}
