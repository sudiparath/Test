package ExecutionTime;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class FindFailureCount {
	 
    /**
    * @param args
    */
    public static String logFilePath = "\\\\aurora.nane.netapp.com\\SHARE\\SANScreenDocs\\MSys\\PlaybackLogs\\Functional\\v-7.0.3\\180";
//public static String logFilePath = "\\\\satyanak01.nane.netapp.com\\C$\\gitviews\\rft\\QA\\RFT_SANscreen_logs";
//public static String logFilePath = "\\\\satyanak01.nane.netapp.com\\C$\\cc_views\\V7.0_RFT_2\\SANscreen\\QA\\RFT_SANscreen_logs";
    //public static String logFilePath = "\\\\oci-mohammaf.nane.netapp.com\\C$\\cc_views\\V7.0_RFT\\SANscreen\\QA\\RFT_SANscreen_logs";
    public static List<String> testSets = new ArrayList<String>();
   
    static{
//              //Fayaz test cases
//                    testSets.add("Task");
//                    testSets.add("Autopolicy_SCSI");
//                    testSets.add("DWH_Troubleshooting");
//                    testSets.add("IP Identity");
//                    testSets.add("Annotation Utility");
//                    testSets.add("Auto Define Tapes");
//                    testSets.add("Olympus");
//                    testSets.add("Reservation");
//                    testSets.add("Vulnerabilities");
//                    testSets.add("Pending Tasks");
//                    testSets.add("Annotation On Storage Objects");
//                    testSets.add("Hierarchical BU");
//                    testSets.add("Daily Phone Home");
//              // Prasad Test cases
//                    testSets.add("Application Management");
//                    testSets.add("Identify");
//                    testSets.add("Violations");
//                    testSets.add("Auto Policy");
//                    testSets.add("Switch_Migration");
//                    testSets.add("Cp Portal");
//                    testSets.add("Federal");
//                    testSets.add("Consolidated Violations");
//                    testSets.add("Consolidated Violations2");
//                    testSets.add("Licenses");
//                    testSets.add("Igman DWH License Schema Restriction");
////                testSets.add("Landing Pages");
////                testSets.add("Search");
//              // Jayakumar Test cases
                    testSets.add("Service Level");
                    testSets.add("Snapshot Support");
                    testSets.add("QTree");
                    testSets.add("VM Datastore");
                    testSets.add("Reservation By Path");
               // Anshuman test cases
                    testSets.add("Auto Host Resolution");
                    testSets.add("Dynamic Annotations");
                    testSets.add("GlobalPolicies_VMHostThreshold");
    }
   
    public static void main(String[] args) {
                    File logFileLocation = new File(logFilePath);
                   
                    if(!logFileLocation.exists()){
                                    System.out.println("Location not found - " + logFilePath);
                                    return;
                    }
                    List<File> logFolders = new ArrayList<File>(getLogFolders(logFileLocation));
                   
                    filterLogFolders(logFolders, testSets);
                    List<TestResult> results = new ArrayList<TestResult>();
                    for(File logFolder : logFolders){
                                    String scriptName = logFolder.getName();
                                    String testSetName = parseToTestSetName(scriptName);
                                    String startDate = null;
                                    int executionTime = -1;
                                    List<String> failureMessages = new ArrayList<String>();
                                    File logFile = new File(logFolder, "rational_ft_logframe.html");
                                    BufferedReader reader = null;
                                    try{
                                                    reader = new BufferedReader(new FileReader(logFile));
                                                    String line = null;
                                                    boolean failureFound = false;
                                                    while((line = reader.readLine()) != null){
                                                                    if(startDate == null && line.contains("<TD CLASS=\"time\">")){
                                                                                    startDate = parseToStartDate(line);
                                                                    }
                                                                    else if(line.contains(">FAIL</TD>")){
                                                                                    failureFound = true;
                                                                    }else if(failureFound && line.contains("<TD CLASS=\"note\">")){
                                                                                    failureMessages.add(parseToFailureMessage(line));
                                                                                    failureFound = false;
                                                                    }else if(line.contains(">EXECUTION TIME")){
                                                                                    executionTime = parseToExecutionTime(line);
                                                                    }
                                                    }
                                    }catch(IOException ie){
                                                    ie.printStackTrace();
                                    }finally{
                                                    if(reader != null){
                                                                    try{ reader.close(); }catch(IOException ie2){}
                                                    }
                                    }
                                    if(failureMessages.size() > 0){
                                                    failureMessages.remove(failureMessages.size() - 1);
                                                    executionTime *= -1;
                                    }
                                    int ind = results.indexOf(new TestResult(testSetName));
                                    if(ind < 0){
                                                    List<Integer> exeTimeList = new ArrayList<Integer>();
                                                    exeTimeList.add(executionTime);
                                                    Map<String, List<String>> failures = new HashMap<String, List<String>>();
                                                    if(failureMessages.size() > 0){
                                                                    failures.put(scriptName, failureMessages);
                                                    }
                                                    results.add(new TestResult(testSetName, 1, failureMessages.size() == 0, exeTimeList, startDate, failures));
                                    }else{
                                                    TestResult oldResult = results.get(ind);
                                                    List<Integer> exeTimeList = oldResult.executionTime;
                                                    exeTimeList.add(executionTime);
                                                    Map<String, List<String>> failures = oldResult.failures;
                                                    if(failureMessages.size() > 0){
                                                                    failures.put(scriptName, failureMessages);
                                                    }
                                                    results.set(ind, new TestResult(testSetName, oldResult.noOfScripts + 1,
                                                                                    oldResult.result && failureMessages.size() == 0, exeTimeList, oldResult.startDate, failures));
                                    }
                    }
                    for(TestResult result : results){
                                    System.out.println(result);
                    }
    }
   
    public static int parseToExecutionTime(String line){
                    if(line.contains("(secs)")){
                                    return 1;
                    }else{
                                    return Integer.parseInt(line.substring(line.lastIndexOf(" ") + 1, line.indexOf("</TD>")));
                    }
    }
   
    public static String parseToFailureMessage(String line){
                    return line.substring("<TD CLASS=\"note\">".length(), line.indexOf("</TD>") > 0 ? line.indexOf("</TD>") : line.length() - 1);
    }
   
    public static String parseToTestSetName(String scriptName){
                    return scriptName.substring(scriptName.indexOf(".", "testcases.".length() + 1) + 1, scriptName.lastIndexOf("."));
    }
   
    public static String parseToStartDate(String line){
                    return line.substring("<TD CLASS=\"time\">".length(), line.indexOf(" ", "<TD CLASS=\"time\">".length() + 1));
    }
   
    public static void filterLogFolders(List<File> logFoldersAvailable, List<String> testSetsToBeConsidered){
                    if(testSetsToBeConsidered == null || testSetsToBeConsidered.isEmpty()){
                                    return;
                    }
                    int len = logFoldersAvailable.size();
                    for(int i = 0; i < len; i++){
                                    boolean found = false;
                                    String logFolderName = logFoldersAvailable.get(i).getName();
                                    for(String testSet : testSetsToBeConsidered){
                                                    if(logFolderName.toLowerCase().replaceAll("_", "").contains("." + testSet.replaceAll("\\s+", "").toLowerCase().replaceAll("_", "") + ".")){
                                                                    found = true;
                                                                    break;
                                                    }
                                    }
                                    if(!found){
                                                    logFoldersAvailable.remove(i);
                                                    len--;
                                                    i--;
                                    }
                    }
    }
   
    public static List<File> getLogFolders(File logFileLocation){
                    File[] logFolders = logFileLocation.listFiles(new FileFilter() {
                                    @Override
                                    public boolean accept(File pathname) {
                                                    return pathname.isDirectory() && pathname.getName().startsWith("testcases.");
                                    }
                    });
                    return Arrays.asList(logFolders);
    }

}
