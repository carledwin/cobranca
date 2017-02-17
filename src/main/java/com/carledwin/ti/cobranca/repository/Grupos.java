package com.carledwin.ti.cobranca.repository;

import com.carledwin.ti.cobranca.model.Usuario;

public interface Grupos {

	Usuario findByUsuariosIn(Usuario usuario);

}
