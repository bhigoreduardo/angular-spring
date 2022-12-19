export class TodoModel {
    id: number;
	descricao: string;
	status: Boolean;
	dataCadastro: Date;
	dataFinalizacao: Date;
}

export class TodoInput {
    descricao: string;
}