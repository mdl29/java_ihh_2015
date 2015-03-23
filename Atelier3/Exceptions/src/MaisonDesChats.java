
public class MaisonDesChats {

	int pelotte_de_laine;
	int nombre_de_chat;

	public MaisonDesChats (int nbrChat, int nbrPelotte) throws ChatException // On crée le constructeur de MaisonDesChats et on le prévient qu'une exception de type ChatException est possible (littéralement "jetable")
	{
		if (nbrPelotte<nbrChat) throw new ChatException();//Si le nombre de pelotte de laine est inférieur au nombre de chat, alors on va dans la classe ChatException
		else { //Autrement, tout va bien :)
			System.out.println("Tous tes chats s'amusent !");
		}
	}
	
		public static void main(String[] args) {
		
			try{// Obligé de mettre MaisonDesChats dans le try car susceptible de generer une exception
				MaisonDesChats m = new MaisonDesChats(10,5);
				
				//2eme exemple avec MaisonDesChats m = new MaisonDesChats(3,4);
			}
			catch (ChatException e){e.printStackTrace();}
		}

}
