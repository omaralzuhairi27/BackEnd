package CaffeeCan.Controller;

import CaffeeCan.Modle.Bean;
import lombok.experimental.UtilityClass;
import lombok.extern.java.Log;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
@Log
@UtilityClass
public class BeansStatistic {
    public String beansStatistic(Queue<Bean> beans){
        long black = beans.stream()
                .filter(e -> e.getColor().equals("black"))
                .count();
        Integer white=beans.size()-(int)black;
        log.severe("black;white;lastElement");
        Integer blackPercentage=(int)black*100/beans.size();
        Integer whitePercentage=(white*100)/beans.size();
        List <String> theLastElement = BeansGenerator.getTheLastElement(beans);
        return ""+ blackPercentage+";"+whitePercentage+";"+theLastElement;
        //log.severe("The black is: "+((int)black*100)/beans.size() + "The white is: "+(white*100)/beans.size()+"theLastElement");
    }
}
