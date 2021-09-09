package br.com.teste.util.jsf;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

public class FacesUtil {

	public static boolean isPostback() {
		return FacesContext.getCurrentInstance().isPostback();
	}
	
	public static boolean isNotPostback() {
		return !isPostback();
	}
	
	public static void addErrorMessage(String message) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));
	}
	
	public static void addInfoMessage(String message) {
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
	}
	
	/**
	 * @param Nome do parametro
	 * @return retorna o paramentro passado pela URI
	 */
	public static String getParameter(String key) {		
		return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(key);		
	}
	
	@Deprecated
	public static void setToClipboard(String texto) {
		Clipboard board = Toolkit.getDefaultToolkit().getSystemClipboard();  
		ClipboardOwner selection = new StringSelection(texto);  
		board.setContents((Transferable) selection, selection);
	}
	
	@Deprecated
	public static String getToClipboard(Object clazz) throws UnsupportedFlavorException, IOException {
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();  
		Transferable contents = clipboard.getContents(clazz);  
		if (contents == null) {  
		    // TODO vazio  
		} else if (contents.isDataFlavorSupported(DataFlavor.stringFlavor)) {  
		   return (String) contents.getTransferData(DataFlavor.stringFlavor);  
		    // TODO processar o texto  
		} else {  
		    // não contem texto (imagem?)  
		}
		return "";  
	}
	
	public static void redirecionarPagina(String pagina) {
        FacesContext context = FacesContext.getCurrentInstance();
        String url = context.getExternalContext().getRequestContextPath();
        try {
            context.getExternalContext().redirect(url + "/" + pagina);
        } catch (IOException ex) {
            Logger.getLogger(FacesUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	
	/**
	 * Executa JavaScript
	 */
	public static void execute(String value) {
		RequestContext.getCurrentInstance().execute(value);
	}

	/**
	 * Atualiza form
	 */
	public static void update(String value) { 
		RequestContext.getCurrentInstance().update(value);
	}
	
}