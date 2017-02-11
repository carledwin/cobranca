$('#dialogoConfirmacaoExclusaoModal').on('show.bs.modal', function(event){
	
	var button = $(event.relatedTarget);
	var codigoTitulo = button.data('codigo');
	var descricaoTitulo = button.data('descricao');
	
	var modal = $(this);
	var form = modal.find('form');
	var action = form.attr('action');
	var colorBlue = 'color:blue';
	if(!action.endsWith('/')){
		action+='/';
	}
	
	form.attr('action', action + codigoTitulo);
	modal.find('.modal-body').html('<strong>Tem certeza que deseja excluir o titulo: <font style= '+ colorBlue +'>'+descricaoTitulo+'</font><strong>?');
});