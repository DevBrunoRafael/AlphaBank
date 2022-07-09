package App.Service.sql;

public class Queries {

    public static final String INSERT_CLIENT =
            "insert into cliente (nome, sobrenome, idade, cpf) values (?,?,?,?);";
    public static final String SELECT_CLIENT =
            "select * from tech_bank.cliente where cpf = ?;";
    public static final String DELETE_CLIENT =
            "delete from cliente where cpf = ?;";


    public static final String INSERT_ACCOUNT =
            "insert into conta (num_conta, saldo, cpf_cliente) values (?,?,?);";
    public static final String SELECT_ACCOUNT =
            "select * from tech_bank.conta where num_conta = ?;";
    public static final String UPDATE_ACCOUNT =
            "UPDATE conta SET saldo = ? WHERE num_conta = ?;";
    public static final String DELETE_ACCOUNT =
            "delete from conta where num_conta = ?;";


    public static final String INSERT_LOGS =
            "insert into log (nome_cliente, valor, tipo_op, data, horario, rem_dest, num_conta) values(?,?,?,?,?,?,?);";
    public static final String SELECT_LOGS =
            "SELECT * FROM tech_bank.log where num_conta = ?;";
    public static final String DELETE_LOGS =
            "delete from log where num_conta = ?;";


}
