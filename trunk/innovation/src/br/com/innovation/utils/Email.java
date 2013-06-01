package br.com.innovation.utils;

import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class Email {

	public static void enviaEmailCompra(Integer ordem, String usuario) throws EmailException, MalformedURLException {  

		HtmlEmail email = new HtmlEmail();  
		StringBuilder emailMsg = new StringBuilder();

		emailMsg.append("<html>");
		emailMsg.append("	<body>");
		emailMsg.append("		<table>");
		emailMsg.append("			<tr>");
		emailMsg.append("				<td>");
		emailMsg.append("					Olá "+usuario+"!");
		emailMsg.append("				</td>");
		emailMsg.append("			</tr>");
		emailMsg.append("			<tr>");
		emailMsg.append("				<td>");
		emailMsg.append("					Seu pedido foi efetuado com sucesso!");
		emailMsg.append("				</td>");
		emailMsg.append("			</tr>");
		emailMsg.append("			<tr>");
		emailMsg.append("				<td>");
		emailMsg.append("					Estamos aguardando a confirmação de pagamento.");
		emailMsg.append("				</td>");
		emailMsg.append("			</tr>");
		emailMsg.append("			<tr>");
		emailMsg.append("				<td>");
		emailMsg.append("					Para acompanhar seu pedido acesse nosso site na aba MEUS PEDIDOS!");
		emailMsg.append("				</td>");
		emailMsg.append("			</tr>");
		emailMsg.append("			<tr>");
		emailMsg.append("				<td>");
		emailMsg.append("					Ordem de compra: "+ordem);
		emailMsg.append("				</td>");
		emailMsg.append("			</tr>");
		
		emailMsg.append("			<tr>");
		emailMsg.append("				<td>");
		emailMsg.append("					Agradecemos sua preferencia");
		emailMsg.append("				</td>");
		emailMsg.append("			</tr>");
		emailMsg.append("		</table>");
		emailMsg.append("	</body>");
		emailMsg.append("</html>");


				// adiciona uma imagem ao corpo da mensagem e retorna seu id  
				URL url = new URL("http://www.apache.org/images/asf_logo_wide.gif");  
				String cid = email.embed(url, "Apache logo");     

				// configura a mensagem para o formato HTML  
				email.setHtmlMsg(emailMsg.toString());  

				// configure uma mensagem alternativa caso o servidor não suporte HTML  
				email.setTextMsg("Seu servidor de e-mail não suporta mensagem HTML");  

				email.setHostName("smtp.gmail.com"); // o servidor SMTP para envio do e-mail  
				email.addTo("metalurgicametodo@gmail.com", "metalurgicametodo@gmail.com"); //destinatário  
				email.setFrom("metalurgicametodo@gmail.com", "metalurgicametodo@gmail.com"); // remetente  
				email.setSubject("Teste -> Html Email"); // assunto do e-mail  
				//        email.setMsg("Teste de Email HTML utilizando commons-email"); //conteudo do e-mail  
				email.setAuthentication("metalurgicametodo@gmail.com", "metodo123");  
				email.setSmtpPort(465);  
				email.setSSL(true);  
				email.setTLS(true);  
				// envia email  
				email.send();  
	}  
}

