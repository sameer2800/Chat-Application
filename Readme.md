##screenshots :
 
 ![alt tag](https://github.com/sameer2800/Chat-Application/blob/master/server.jpg)
  	
  				server 
  	

 ![alt tag](https://github.com/sameer2800/Chat-Application/blob/master/client.jpg)
				
				 client 



##Description :
	
	A java GUI based Chat application made by using socket programming and
	thread programming. It supports multiple clients also. Encryption technique 
	JEC  is used for encrypting and decrypting the data hence  provides
	 better security. Authentication is required when u run the GUI codes 
	 and password is root. :) 

##Installation :
	
	Clone the project and run it by using normal java commands. else import
	the project in netbeans as i made it in netbeans. 


##Design and Details :
	
	this project contains 4 packages in total.so we can send information 
	continously without waiting from other side. Every client requires 
	authentication and PASSWORD for clients : root. Display name in GUI 
	clients is username (the name to display) and password must be root.
	this password is stored in server side. (we can modify to anyting ) and also
	we can maintain list of usernames and passwords.

	package 1 : single-Server-client (without GUI)
		Description : this server can connect to only one client. input and 
		output through terminal.

	package 2 : Multipleclients-singleServer (without GUI)
		Description : A single server to multiple clients. input through clients.

	package 3 : single-server_client_GUI (GUI)
		Description : A complete GUI for a single server to a single client.

	package 4 : multipleclients-single server (GUI)
		Description : this is exactly like groupchat in facebook and in additional 
		server also can send messages to all the clients.

	package 5 : encrytped multipleclients-single server (GUI) (JEC - encryption)
		Description : I Encrypted messages by using cipher and secretkey .I used same
		secretkey both in server and client side and an instance of Cipher.	



