interface StringArray {
    [index: number]: string;
}

export interface McqData {
  statement:string,
  options: StringArray,
  correctOptions: StringArray,
  description: string
}
