package com.zsg.micro;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleInsultRestController {

	@Autowired
	private InsultNounRepo nounRepo;
	
	@Autowired
	private InsultLongAdjectiveRepo longAdjectiveRepo;
	
	@Autowired
	private InsultShortAdjectiveRepo shortAdjectiveRepo;
	
	@GetMapping("/v1/api/simple/insult")
	public InsultResponse generateInsult() {
		String words[][] = {{"Artless", "Bawdy", "Beslubbering"}, {"Base-court", "Bat-fowling", "Beef-witted"}, {"Apple-john", "Baggage", "Barnacle"}};
		String vowels = "AEIOU";
		String article = "an";
		String firstAdjective = words[0][new Random().nextInt(words[0].length)];
		String secondAdjective = words[1][new Random().nextInt(words[1].length)];
		String noun = words[2][new Random().nextInt(words[2].length)];
		if (vowels.indexOf(firstAdjective.charAt(0)) == -1) {
			article = "a";
		}
		
		InsultResponse res = new InsultResponse();
		StringBuilder stBuilder = new StringBuilder("Thou art ");
		stBuilder.append(article + " ");
		stBuilder.append(firstAdjective + " ");
		stBuilder.append(secondAdjective + " ");
		stBuilder.append(noun);
		
		res.setInsult(stBuilder.toString());
		return res;
	}
	
	@GetMapping("/v2/api/simple/insult")
	public InsultResponse getInsult() {
		String vowels = "AEIOU";
		String lowerCaseVowels = "aeiou";
		String article = "an";
		
		List<InsultNoun> nouns = nounRepo.findAll();
		List<InsultLongAdjective> longAdjectives = longAdjectiveRepo.findAll();
		List<InsultShortAdjective> shortAdjectives = shortAdjectiveRepo.findAll();
		
		InsultNoun noun = nouns.get(new Random().nextInt(nouns.size()));
		InsultLongAdjective longAdjective = longAdjectives.get(new Random().nextInt(longAdjectives.size()));
		InsultShortAdjective shortAdjective = shortAdjectives.get(new Random().nextInt(shortAdjectives.size()));
		
		if (vowels.indexOf(shortAdjective.getAdjective().charAt(0)) == -1 && lowerCaseVowels.indexOf(shortAdjective.getAdjective().charAt(0)) == -1) {
			article = "a";
		}
		
		InsultResponse res = new InsultResponse();
		StringBuilder stBuilder = new StringBuilder("Thou art ");
		stBuilder.append(article + " ");
		stBuilder.append(shortAdjective.getAdjective() + " ");
		stBuilder.append(longAdjective.getAdjective() + " ");
		stBuilder.append(noun.getNoun());
		
		res.setInsult(stBuilder.toString());
		return res;
	}
}
