
public class CharCode {
	
	// Decoder
	
	public Character decodeChar(String charCode){
		Character finalChar = new Character("");
		finalChar.setName(charCode.substring(0, charCode.indexOf(">")));
		charCode = charCode.substring(charCode.indexOf(">")+1);
		finalChar.setLevel(Integer.parseInt(charCode.substring(0, charCode.indexOf("<"))));
		charCode = charCode.substring(charCode.indexOf("<")+1);
		finalChar.getRace().setName(charCode.substring(0, charCode.indexOf(">")));
		charCode = charCode.substring(charCode.indexOf(">")+1);
		finalChar.getRace().setStrMod(Integer.parseInt(charCode.substring(0, charCode.indexOf(">"))));
		charCode = charCode.substring(charCode.indexOf(">")+1);
		finalChar.getRace().setConMod(Integer.parseInt(charCode.substring(0, charCode.indexOf(">"))));
		charCode = charCode.substring(charCode.indexOf(">")+1);
		finalChar.getRace().setIntMod(Integer.parseInt(charCode.substring(0, charCode.indexOf(">"))));
		charCode = charCode.substring(charCode.indexOf(">")+1);
		finalChar.getRace().setWisMod(Integer.parseInt(charCode.substring(0, charCode.indexOf(">"))));
		charCode = charCode.substring(charCode.indexOf(">")+1);
		finalChar.getRace().setChaMod(Integer.parseInt(charCode.substring(0, charCode.indexOf(">"))));
		charCode = charCode.substring(charCode.indexOf(">")+1);
		finalChar.getRace().setDexMod(Integer.parseInt(charCode.substring(0, charCode.indexOf("<"))));
		charCode = charCode.substring(charCode.indexOf("<")+1);
		finalChar.getStatus().setHealth(Integer.parseInt(charCode.substring(0, charCode.indexOf(">"))));
		charCode = charCode.substring(charCode.indexOf(">")+1);
		finalChar.getStatus().setNonlethal(Integer.parseInt(charCode.substring(0, charCode.indexOf(">"))));
		charCode = charCode.substring(charCode.indexOf("<")+1);
		while(!(charCode.substring(0, 1).equals("<"))){
			finalChar.getStatus().startEffect(Integer.parseInt(charCode.substring(0, charCode.indexOf(">"))));
			charCode = charCode.substring(charCode.indexOf(">")+1);
		}
		charCode = charCode.substring(1);
		finalChar.getValues().setStr(Integer.parseInt(charCode.substring(0, charCode.indexOf(">"))));
		charCode = charCode.substring(charCode.indexOf(">")+1);
		finalChar.getValues().setCon(Integer.parseInt(charCode.substring(0, charCode.indexOf(">"))));
		charCode = charCode.substring(charCode.indexOf(">")+1);
		finalChar.getValues().setInt(Integer.parseInt(charCode.substring(0, charCode.indexOf(">"))));
		charCode = charCode.substring(charCode.indexOf(">")+1);
		finalChar.getValues().setWis(Integer.parseInt(charCode.substring(0, charCode.indexOf(">"))));
		charCode = charCode.substring(charCode.indexOf(">")+1);
		finalChar.getValues().setCha(Integer.parseInt(charCode.substring(0, charCode.indexOf(">"))));
		charCode = charCode.substring(charCode.indexOf(">")+1);
		finalChar.getValues().setDex(Integer.parseInt(charCode.substring(0, charCode.indexOf(">"))));
		charCode = charCode.substring(charCode.indexOf("<")+1);
		while(!(charCode.substring(0, 1).equals("<"))){
			InvItem item = new InvItem(charCode.substring(0, charCode.indexOf(">")));
			charCode = charCode.substring(charCode.indexOf(">")+1);
			item.setValue(Integer.parseInt(charCode.substring(0, charCode.indexOf(">"))));
			finalChar.getInv().add(item);
			charCode = charCode.substring(charCode.indexOf(">")+1);
		}
		charCode = charCode.substring(1);
		finalChar.getClass1().setName(charCode.substring(0, charCode.indexOf(">")));
		charCode = charCode.substring(charCode.indexOf(">")+1);
		finalChar.getClass1().setLevel(Integer.parseInt(charCode.substring(0, charCode.indexOf(">"))));
		charCode = charCode.substring(charCode.indexOf(">")+1);
		while(!(charCode.substring(0, 1).equals("<"))){
			finalChar.getClass1().addSkill(charCode.substring(0, charCode.indexOf(">")));
			charCode = charCode.substring(charCode.indexOf(">")+1);
		}
		charCode = charCode.substring(1);
		finalChar.getClass2().setName(charCode.substring(0, charCode.indexOf(">")));
		charCode = charCode.substring(charCode.indexOf(">")+1);
		finalChar.getClass2().setLevel(Integer.parseInt(charCode.substring(0, charCode.indexOf(">"))));
		charCode = charCode.substring(charCode.indexOf(">")+1);
		while(!(charCode.substring(0, 1).equals("<"))){
			finalChar.getClass2().addSkill(charCode.substring(0, charCode.indexOf(">")));
			charCode = charCode.substring(charCode.indexOf(">")+1);
		}
		charCode = charCode.substring(1);
		finalChar.getClass3().setName(charCode.substring(0, charCode.indexOf(">")));
		charCode = charCode.substring(charCode.indexOf(">")+1);
		finalChar.getClass3().setLevel(Integer.parseInt(charCode.substring(0, charCode.indexOf(">"))));
		charCode = charCode.substring(charCode.indexOf(">")+1);
		while(!(charCode.substring(0, 1).equals("<"))){
			finalChar.getClass3().addSkill(charCode.substring(0, charCode.indexOf(">")));
			charCode = charCode.substring(charCode.indexOf(">")+1);
		}
		charCode = charCode.substring(1);
		finalChar.getClass4().setName(charCode.substring(0, charCode.indexOf(">")));
		charCode = charCode.substring(charCode.indexOf(">")+1);
		finalChar.getClass4().setLevel(Integer.parseInt(charCode.substring(0, charCode.indexOf(">"))));
		charCode = charCode.substring(charCode.indexOf(">")+1);
		while(!(charCode.substring(0, 1).equals("<"))){
			finalChar.getClass4().addSkill(charCode.substring(0, charCode.indexOf(">")));
			charCode = charCode.substring(charCode.indexOf(">")+1);
		}
		return finalChar;
	}
	
	// Encoder
	
	public String encodeChar(Character codeChar){
		String finalCode = "";
		finalCode += codeChar.getName()+">"+codeChar.getLevel()+"<";
		finalCode += codeChar.getRace().getName()+">"+codeChar.getRace().getStrMod()+">"+codeChar.getRace().getConMod()+">"+codeChar.getRace().getIntMod()+">"+codeChar.getRace().getWisMod()+">"+codeChar.getRace().getChaMod()+">"+codeChar.getRace().getDexMod()+"<";
		finalCode += codeChar.getStatus().getHealth()+">"+codeChar.getStatus().getNonlethal()+">"+codeChar.getStatus().isConscious()+"<";
		while(codeChar.getStatus().getEffectList().size() > 0){
			finalCode += codeChar.getStatus().getEffectList().remove(0)+">";
		}
		finalCode += "<"+codeChar.getValues().getStr()+">"+codeChar.getValues().getCon()+">"+codeChar.getValues().getInt()+">"+codeChar.getValues().getWis()+">"+codeChar.getValues().getCha()+">"+codeChar.getValues().getDex()+"<";
		while(codeChar.getInv().size() > 0){
			finalCode += codeChar.getInv().get(0).getName()+">"+codeChar.getInv().get(0).getValue()+">";
			codeChar.getInv().remove(0);
		}
		finalCode += "<";
		finalCode += codeChar.getClass1().getName()+">"+codeChar.getClass1().getLevel()+">";
		while(codeChar.getClass1().getSkillList().size() > 0){
			finalCode += codeChar.getClass1().getSkillList().remove(0)+">";
		}
		finalCode += "<";
		finalCode += codeChar.getClass2().getName()+">"+codeChar.getClass2().getLevel()+">";
		while(codeChar.getClass2().getSkillList().size() > 0){
			finalCode += codeChar.getClass2().getSkillList().remove(0)+">";
		}
		finalCode += "<";
		finalCode += codeChar.getClass3().getName()+">"+codeChar.getClass3().getLevel()+">";
		while(codeChar.getClass3().getSkillList().size() > 0){
			finalCode += codeChar.getClass3().getSkillList().remove(0)+">";
		}
		finalCode += "<";
		finalCode += codeChar.getClass4().getName()+">"+codeChar.getClass4().getLevel()+">";
		while(codeChar.getClass4().getSkillList().size() > 0){
			finalCode += codeChar.getClass4().getSkillList().remove(0)+">";
		}
		finalCode += "<";
		return finalCode;
	}
}
