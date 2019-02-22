import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}editorPickProductManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}editorPickProductManager/loadEditorPickProduct/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateParentCategory = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}editorPickProductManager/requestCandidateParentCategory/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherParentCategory = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}editorPickProductManager/transferToAnotherParentCategory/id/anotherParentCategoryId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateBrand = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}editorPickProductManager/requestCandidateBrand/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherBrand = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}editorPickProductManager/transferToAnotherBrand/id/anotherBrandId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateCatalog = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}editorPickProductManager/requestCandidateCatalog/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherCatalog = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}editorPickProductManager/transferToAnotherCatalog/id/anotherCatalogId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateProfile = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}editorPickProductManager/requestCandidateProfile/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherProfile = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}editorPickProductManager/transferToAnotherProfile/id/anotherProfileId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidatePlatform = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}editorPickProductManager/requestCandidatePlatform/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherPlatform = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}editorPickProductManager/transferToAnotherPlatform/id/anotherPlatformId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}






const EditorPickProductService = { view,
  load,
  requestCandidateParentCategory,
  requestCandidateBrand,
  requestCandidateCatalog,
  requestCandidateProfile,
  requestCandidatePlatform,
  transferToAnotherParentCategory,
  transferToAnotherBrand,
  transferToAnotherCatalog,
  transferToAnotherProfile,
  transferToAnotherPlatform }
export default EditorPickProductService

