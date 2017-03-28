$('#dialogoConfirmacaoExclusaoModal').on('show.bs.modal', function(event){
	
	var button = $(event.relatedTarget);
	var codigoTitulo = button.data('id');
	var descricaoTitulo = button.data('descricao');
	
	var modal = $(this);
	var form = modal.find('form');
	var action = form.data('url-base');
	var colorBlue = 'color:blue';
	if(!action.endsWith('/')){
		action+='/';
	}
	
	form.attr('action', action + codigoTitulo);
	modal.find('.modal-body').html('<strong>Tem certeza que deseja excluir o titulo: <font style= '+ colorBlue +'>'+descricaoTitulo+'</font><strong>?');
});

$(function(){
	$('[rel="tooltip"]').tooltip();
	$('.js-currency').maskMoney({decimal: ',', thousands:'.', allonZero:true});
	$('.js-atualizar-status').on('click',function(event){
		event.preventDefault();
		var botaoReceber = $(event.currentTarget);
		var urlReceber = botaoReceber.attr('href');
	
		var response = $.ajax({
			url:urlReceber,
			type:'PUT'
		});
		
		response.done(function(e){
			var codigoTitulo = botaoReceber.data('id');
			$('[data-role=' + codigoTitulo + ']').html('<span class="label label-success">'+e+'</span>');
			botaoReceber.hide();
		})
		
		response.fail(function(e){
			console.log(e);
			alert('Erro recebendo cobrança.');
		})
		
	});
});

