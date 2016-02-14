package com.spider.common.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Upload {

	public String upload(String resultText,String rootPath) throws Exception{
		/*JSONObject currentResultParamMap = JSONUtil.parseObject(resultText);
		//MultipartHttpServletRequest multipartRequest  =  (MultipartHttpServletRequest) request;
		 //MultipartFile file = multipartRequest.getFile("edui_input_"+params.get("timestrap"));
		File file = new File(rootPath+currentResultParamMap.getString("url"));
		String jsonResult = "";
		if(file.exists()){
			String url=FtpUpload(file,currentResultParamMap.getString("title"));
			JSONObject json = new JSONObject();
			if(null!=url&&!"".equals(url)){
				json.put("state", "SUCCESS");
			}else{
				json.put("state", "FAIL");
			}
			json.put("title", currentResultParamMap.getString("title"));
			json.put("original", currentResultParamMap.getString("original"));
			json.put("type", currentResultParamMap.getString("type"));
			json.put("url",Config.HttpFtpUrl+url);
			json.put("size",currentResultParamMap.getString("size"));
			jsonResult = json.toJSONString();
		}*/
		 return null;
	}

	/*private String FtpUpload(File uploadedFile, String fileName)
			throws Exception {
		String host = Config.FtpHost;
		int port = Config.Port;
		String uname = Config.Uname;
		String pass = Config.Pass;
		String serverpath = Config.ServerPath;

		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String savePath = sdf.format(now) + "/" + fileName;

		FTPEngine engine = FTPEngine.getInstance();
		FTPClient ftpClient = new FTPClient();
		engine.connect(ftpClient, host, port, uname, pass);
		engine.upload(uploadedFile, serverpath + savePath);
		engine.disconnect();

		uploadedFile.delete();
		return savePath;
	}*/
}
