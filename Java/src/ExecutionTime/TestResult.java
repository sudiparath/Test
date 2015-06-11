package ExecutionTime;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
class TestResult{
                String testSetName;
                int noOfScripts;
                boolean result;
                List<Integer> executionTime;
                String startDate;
                Map<String, List<String>> failures = new HashMap<String, List<String>>();
               
                public TestResult(String testSetName){
                                this.testSetName = testSetName;
                }
               
                public TestResult(String testSetName, int noOfScripts, boolean result, List<Integer> executionTime, String startDate, Map<String, List<String>> failures){
                                this.testSetName = testSetName;
                                this.noOfScripts = noOfScripts;
                                this.result = result;
                                this.executionTime = executionTime;
                                this.startDate = startDate;
                                this.failures = failures;
                }
               
                @Override
                public boolean equals(Object obj){
                                return (obj instanceof TestResult) && (this.testSetName.equals(((TestResult)obj).testSetName));
                }
               
                @Override
                public String toString(){
                                String str = "";
                                str += this.testSetName;
                                str += " - " + this.noOfScripts;
                                str += " - " + this.startDate;
                                if(this.result){
                                                str += " - Passed - ";
                                }else{
                                                str += " - Failed - ";
                                }
                                if(this.noOfScripts == 1){
                                                int exeTime = this.executionTime.get(0);
                                                if(exeTime < 0){
                                                                exeTime *= -1;
                                                                str += exeTime + " min(F)(" + (exeTime / 60) + ":" + String.format("%02d", exeTime % 60) + ")";
                                                }else{
                                                                str += exeTime + " min(" + (exeTime / 60) + ":" + String.format("%02d", exeTime % 60) + ")";
                                                }
                                }else{
                                                boolean isFirst = true;
                                                int totalExecutionTime = 0;
                                                boolean isFailed = false;
                                                for(int exeTime : this.executionTime){
                                                                if(isFirst){
                                                                                str += (exeTime < 0 ? ((exeTime * -1) + "(F)") : exeTime);
                                                                                isFirst = false;
                                                                }else{
                                                                                str += ("+" + (exeTime < 0 ? ((exeTime * -1) + "(F)") : exeTime));
                                                                }
                                                                if(exeTime < 0){
                                                                                isFailed = true;
                                                                                totalExecutionTime += (exeTime * -1);
                                                                }else{
                                                                                totalExecutionTime += exeTime;
                                                                }
                                                }
                                                str += "=" + totalExecutionTime + " min" + (isFailed ? "(F)" : "") + "(" + (totalExecutionTime / 60) + ":" + String.format("%02d", totalExecutionTime % 60) + ")";
                                }
                                if(!this.result){
                                                for(String failedScript : failures.keySet()){
                                                                List<String> messages = failures.get(failedScript);
                                                                str += "\n    " + failedScript + " (" + messages.size() + " failures)";
                                                                for(String message : messages){
                                                                                str += "\n        FAIL: " + message;
                                                                }
                                                }
                                }
                                return str;
                }
}
 
