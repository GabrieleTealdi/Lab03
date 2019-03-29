package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Dictionary {
	
	private Set<String> arrayWords = new HashSet<String>();
	
	public void loadDictionary(String language) {
		if(language.equals("English")) {
			try {
				FileReader fr = new FileReader("rsc/English.txt");
				BufferedReader br = new BufferedReader(fr);
				String word;
				while((word=br.readLine())!=null) {
					arrayWords.add(word);
				}
				br.close();
			}catch(IOException e){
				System.out.println("Errore nella lettura del file");
			}
		}
		if(language.equals("Italiano")) {
			try {
				FileReader fr = new FileReader("rsc/Italian.txt");
				BufferedReader br = new BufferedReader(fr);
				String word;
				while((word=br.readLine())!=null) {
					arrayWords.add(word);
				}
				br.close();
			}catch(IOException e){
				System.out.println("Errore nella lettura del file");
			}
		}
	}
	
	public List<RichWord> spellCheckText (List<String> inputTestList){
		List<RichWord> wordsChecked = new ArrayList<RichWord>();
		for(String s: inputTestList) {
			String t = s.toLowerCase();
			if(arrayWords.contains(t))
				wordsChecked.add(new RichWord(s,true));
			else {
				wordsChecked.add(new RichWord(s,false));
			}
		}
		return wordsChecked;
	}
	
	public String stampa(List<RichWord> rw) {
		String s = "";
		for(RichWord r: rw) {
			if(!r.isGiusta())
				s+=r.getParola()+"\n";
		}
		return s.trim();
	}
	public int cntErrors(List<RichWord> rw) {
		int cnt = 0;
		for(RichWord r: rw) {
			if(!r.isGiusta())
				cnt++;
		}
		return cnt;
	}
	public void clearDictionary() {
		arrayWords.clear();
	}

}
