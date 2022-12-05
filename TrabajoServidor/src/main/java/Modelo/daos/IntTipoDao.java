package Modelo.daos;

import Modelo.beans.Tipo;

public interface IntTipoDao {
    Tipo findbyId(int idTipo);
}