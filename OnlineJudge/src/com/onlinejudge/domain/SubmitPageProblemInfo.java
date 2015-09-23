package com.onlinejudge.domain;

/**
 * @author ��Ц��
 *
 * @time 2015��9��22��
 * 
 */
public class SubmitPageProblemInfo {
		private int problemid;
		private String problemtitle;
		
		public SubmitPageProblemInfo(int problemid,String problemtitle){
			this.problemid = problemid;
			this.problemtitle = problemtitle;
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

}
