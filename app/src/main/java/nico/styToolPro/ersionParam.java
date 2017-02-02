package nico.styToolPro;


public class ersionParam
{

  public static String receiveUIFunctionName = "a";
  public static String receiveUIParamName = "com.tencent.mm.u.o";
  public static String GET_LUCKY_MONEY_CLASS = "com.tencent.mm.model.ak";
  public static String getNetworkByModelMethod = "vy";
  public static String getMessageClass = "com.tencent.mm.e.b.b";

  public static void init(String version)
  {
	switch (version)
	{
	  case "6.5.4":
		receiveUIFunctionName = "a";
		receiveUIParamName = "com.tencent.mm.u.o";
		GET_LUCKY_MONEY_CLASS = "com.tencent.mm.model.ak";
		getNetworkByModelMethod = "y";
		getMessageClass = "com.tencent.mm.e.b.b";
		break;
	  default:
		receiveUIFunctionName = "d";
		receiveUIParamName = "com.tencent.mm.u.k";
		GET_LUCKY_MONEY_CLASS = "com.tencent.mm.model.ak";
		getNetworkByModelMethod = "y";
		getMessageClass = "com.tencent.mm.e.b.b";
	}
  }
}
