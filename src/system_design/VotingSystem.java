package system_design;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
public class VotingSystem {

    private int numberOfMaxVotes;

    private Map<String,Integer> candidatesVote;

    public VotingSystem(int numberOfMaxVotes) {
        this.numberOfMaxVotes=numberOfMaxVotes;
        this.candidatesVote= new HashMap<>(this.numberOfMaxVotes); // this to avoid hash resizing.
    }
    public static void main(String[] args) {

        VotingSystem voteSystem = new VotingSystem(3);
        
        voteSystem.vote(Arrays.asList("A","B","C"));
        voteSystem.vote(Arrays.asList("B","A","C"));
        voteSystem.vote(Arrays.asList("C","B","A"));
        voteSystem.vote(Arrays.asList("C","B","C"));
        voteSystem.vote(Arrays.asList("A","C","B"));
        voteSystem.vote(Arrays.asList("B","C"));
        voteSystem.vote(Arrays.asList("B"));
        voteSystem.vote(Arrays.asList());

        System.out.println(voteSystem.findWinner());
    }
    

    private void vote(List<String> votes) {
        if(votes.isEmpty()) {
            System.out.println("No vote");
            return; //no vote;
        }
        if(votes.size()>this.numberOfMaxVotes) {
            System.out.println("Wrong vote");
            return; // invalid vote as more options given
        }
        if(isDuplicate(votes)) {
            System.out.println("Duplicate vote");
            return;// duplicate
        }
        for(int i=0;i<votes.size();i++) {
            int weightage = this.numberOfMaxVotes-i;
            if(this.candidatesVote.containsKey(votes.get(i))) {
                int voteCount = this.candidatesVote.get(votes.get(i));
                this.candidatesVote.put(votes.get(i),(voteCount+weightage));
            }else {
                this.candidatesVote.put(votes.get(i),weightage);
            }
        }

    }

    private List<String> findWinner() {
        List<Entry<String,Integer>> votes = this.candidatesVote.entrySet().stream().collect(Collectors.toList());

        Collections.sort(votes,(e1,e2)->{
            if(e1.getValue()>e2.getValue()) {
                return -1;
            }else if(e1.getValue()<e2.getValue()){
                return 1;
            }else {
                return 0;
            }
        });
        
        return votes.stream().map(Entry::getKey).collect(Collectors.toList());
    }

    private boolean isDuplicate(List<String> vote) {
        Set<String> votesSet = new HashSet<>(vote);
        if(votesSet.size() != vote.size()) {
            return true;
        }
        return false;
    }
}