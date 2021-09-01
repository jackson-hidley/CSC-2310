import java.util.ArrayList;
import java.util.Date;

public class Block {
	
	private int blockNum;
	private String hash;
	private MerkleTree merkleTree;
	private String merkleRoot;
	private String previousHash;
	private long timeStamp; //as number of milliseconds since 1/1/1970.
	private int difficulty;
	private int nonce;
	private int numTrans;
	private Block previousBlock; //link to previous block
	
	//DO THIS
	//Block Constructor.  
	public Block(int blockNum, MerkleTree merkleTree, Block previousBlock, int difficulty) {
		this.timeStamp = new Date().getTime();
		
		//update instance variables
		this.blockNum = blockNum;
		this.merkleTree = merkleTree;
		this.previousBlock = previousBlock;
		this.difficulty = difficulty;			

		//obtain the Merkle Root
		this.merkleRoot = merkleTree.getMerkleRoot();

		//if the previous block is null, set the previous hash to 64 0's, otherwise, grab the previous block's hash
		if( previousBlock == null ) 
		{
			previousHash = "0000000000000000000000000000000000000000000000000000000000000000";
		}
		else 
		{
			previousHash = previousBlock.getHash();
		}

		//start the nonce at 0
		nonce = 0;

		//obtain the number of transactions from the Merkle Tree
		numTrans = merkleTree.getTranList().size();

		//calculate and update our hash
		hash = calculateHash();
	}
	
	//Calculate new hash based on a concatenation of the block's contents
	//i.e. timeStamp, difficulty, previous hash, block number, and merkle root
	public String calculateHash() {
		String calculatedhash = SHA256.getSHA( Long.toString(timeStamp) + difficulty + previousHash + blockNum + merkleRoot );
		return calculatedhash;
	}
	
	//create a String display of the relevant information
	//Block #, Total Transactions, Previous Hash, Merkle Root, Hash
	public String toString() {
		return ( "Block #: " + blockNum + "\nTotal Transactions: " + numTrans + "\nPrevious Hash: " + previousHash + "\nMerkle Root: " + merkleRoot + "\nHash: " + hash );
	}
	
	//return a String ArrayList with the relevant Block information for use with the GUI
	//Block #, Total Transactions, Previous Hash, Merkle Root, Hash
	public ArrayList<String> toStringArray() {
		ArrayList<String> relevent = new ArrayList<String>();
		relevent.add("Block #: " + blockNum);
		relevent.add("Total Transactions: " + numTrans);
		relevent.add("Previous Hash: " + previousHash);
		relevent.add("Merkle Root: " + merkleRoot);
		relevent.add("Hash: " + hash);
		return relevent;		
	}
	
	//get method to return this block's hash
	public String getHash() {
		return hash;
	}
	
	//display the list of transactions
	public void displayTransactions() {
		ArrayList<String> tranList = merkleTree.getTranList();
		for( int i = 0; i < tranList.size(); i++ ) 
		{
			System.out.println( "\nTransaction #" + i + ": " + tranList.get(i) );
		}
	}	

	//display the list of hashed transactions
	public void displayHashTransactions() {
		ArrayList<String> hashTranList = merkleTree.getHashTranList();
		for( int i = 0; i < hashTranList.size(); i++ ) 
		{
			System.out.println( "\nHashed Transaction #" + i + ": " + hashTranList.get(i) );
		}		
	}
	
	//Our "Proof of Work" used to mine the block
	public void mineBlock() {
		//start timer
		long startTime = System.nanoTime();
		
		//set a default difficulty if difficulty is less than 1 or greater than 5
		if( difficulty <= 1 || difficulty > 5 )
		{
			difficulty = 3;
		}
		
		//create a target hash String full of 0's 
		String targetHash = "000000000000";
	    
		//take a substring of the target hash, based on the difficulty passed in
		targetHash = targetHash.substring(0, difficulty);

		//brute force until our hash substring equals the target hash (while loop)
		//you will need to update our hash to equal a SHA256 hash of our block hash concatentated with our nonce value
	    //make sure to increment your nonce each time
		while(targetHash == hash.substring(0, difficulty)) 
		{
			hash = SHA256.getSHA(hash + nonce);
			nonce++;
		}

		//calculate and display runtime
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		double seconds = (double)totalTime / 1000000000.0;
		int minutes = (int)seconds / 60;
		if (minutes > 0) 
			seconds = seconds % 60;
		System.out.println("Total Time: " + minutes + " minute(s) " + seconds + " seconds");
		
		//display the list of transactions & hashes
		displayTransactions();
		displayHashTransactions();
	}
}
