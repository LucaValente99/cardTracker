/**
 * VALIDAZIONE DEI DATI tramite il Bootstrap validator (ASINCRONA)
 */
//quando la pagina è completamente caricata gli dico di creare una funzione
$(document).ready( function(){
	$('#corsistaForm').bootstrapValidator({//recuperato da CDN.html
		//il controllo avviene in maniera asincrona, senza dover richiamare quindi il server
		feedbackIcons: { //icone predefinite mostrate per la validazione 
			valid: 'glyphicon glyphicon-ok',
			invalid: 'glyphicon glyphicon-remove',
			validating: 'glyphicon glyphicon-refresh' //fase di validazione
		},
		fields: { //campi da validare
			nome: {
				container: '#infoNome',//dove visualizzare il messagio d'errore
				validators: {
					notEmpty: { //campo non vuoto
						message: 'Il campo nome non può essere vuoto'//mex visualizzato se campo è vuoto
					},
					regexp: {
						/*
						[a-zA-z] -> caratteri validi per il nome utente
						[a-zA-z]{2,30} - min 2, max 30
						[a-zA-z]{2,} - min 2, max non lo so
						[a-zA-z]{30} - 3
						*/
						regexp: /^[a-zA-z,.'-]{2,30}$/, //inizio reg exp: /^, fine: $/.
						message: 'Da 2 a 30 caratteri (solo lettere)'
					}
				}
			},
			cognome: {
				container: '#infoCognome',
				validators: {
					notEmpty: { 
						message: 'Il campo cognome non può essere vuoto'
					},
					regexp: {
						regexp: /^[a-zA-z,.'-]{2,30}$/, 
						message: 'Da 2 a 30 caratteri (solo lettere)'
					}
				}
			},
			nomeCorso: {
				container: '#infoNomeCorso',
				validators: {
					notEmpty: { 
						message: 'Il campo nome corso non può essere vuoto'
					},
					regexp: {
						regexp: /^[a-zA-Z ,.'-]{2,30}$/, //posso usare da 2 a 40 caratteri e da 1 a 4 cifre (ricordiamo infatti che sul db l'indirizzo ha 50 char)
						message: 'Da 2 a 30 caratteri (solo lettere)'
					}
				}
			},	
			dataInizio: {
				container: '#infoDataInizio',
				validators: {
					notEmpty: { 
						message: 'Il campo data inizio corso non può essere vuoto'
					},
					date: {
						format: 'YYYY/MM/DD',
						message: 'Inserire una data valida. Formato YYYY/MM/DD'
					}
				}
			},
			dataFine: {
				container: '#infoDataFine',
				validators: {
					notEmpty: { 
						message: 'Il campo data fine corso non può essere vuoto'
					},
					date: {
						format: 'YYYY/MM/DD',
						message: 'Inserire una data valida. Formato YYYY/MM/DD'
					}
				}
			},
			commenti: {
				container: '#infoCommenti',
				validators: {
					notEmpty: { 
						message: 'Il campo commenti non può essere vuoto'
					},
					regexp: {
						regexp: /^[a-zA-Z0-9 ._]{0,200}$/, 
						message: 'Da 0 a 200 caratteri (Solo lettere e numeri)'
					}
				}
			},
			aulaCorso: {
				container: '#infoAulaCorso',
				validators: {
					notEmpty: { 
						message: 'Il campo aula corso non può essere vuoto'
					},
					regexp: {
						regexp: /^[a-zA-Z0-9._]{2,30}$/, 
						message: 'Da 2 a 30 caratteri (Solo lettere e numeri)'
					}
				}
			}
		}
	}) 
}) 